package me.amitshekhar.learn.kotlin.flow.ui.room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import me.amitshekhar.learn.kotlin.flow.data.api.ApiHelper
import me.amitshekhar.learn.kotlin.flow.data.local.DatabaseHelper
import me.amitshekhar.learn.kotlin.flow.data.local.entity.User
import me.amitshekhar.learn.kotlin.flow.utils.DispatcherProvider
import me.amitshekhar.learn.kotlin.flow.ui.base.UiState

class RoomDBViewModel(
    private val apiHelper: ApiHelper,
    private val dbHelper: DatabaseHelper,
    val dispatcherProvider: DispatcherProvider
) :
    ViewModel() {

    private val _users = MutableStateFlow<UiState<List<User>>>(UiState.Loading)

    val users: StateFlow<UiState<List<User>>> = _users

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch(dispatcherProvider.main) {
            _users.value = UiState.Loading
            dbHelper.getUsers()
                .flatMapConcat { usersFromDb ->
                    if (usersFromDb.isEmpty()) {
                        return@flatMapConcat apiHelper.getUsers()
                            .map { apiUserList ->
                                val userList = mutableListOf<User>()
                                for (apiUser in apiUserList) {
                                    val user = User(
                                        apiUser.id,
                                        apiUser.name,
                                        apiUser.email,
                                        apiUser.avatar
                                    )
                                    userList.add(user)
                                }
                                userList
                            }
                            .flatMapConcat { usersToInsertInDB ->
                                dbHelper.insertAll(usersToInsertInDB)
                                    .flatMapConcat {
                                        flow {
                                            emit(usersToInsertInDB)
                                        }
                                    }
                            }
                    } else {
                        return@flatMapConcat flow {
                            emit(usersFromDb)
                        }
                    }
                }
                .flowOn(dispatcherProvider.io)
                .catch { e ->
                    _users.value = UiState.Error(e.toString())
                }
                .collect {
                    _users.value = UiState.Success(it)
                }
        }
    }

}