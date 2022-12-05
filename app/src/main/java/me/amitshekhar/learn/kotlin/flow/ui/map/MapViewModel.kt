package me.amitshekhar.learn.kotlin.flow.ui.map

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import me.amitshekhar.learn.kotlin.flow.data.api.ApiHelper
import me.amitshekhar.learn.kotlin.flow.data.local.DatabaseHelper
import me.amitshekhar.learn.kotlin.flow.data.local.entity.User
import me.amitshekhar.learn.kotlin.flow.utils.DispatcherProvider
import me.amitshekhar.learn.kotlin.flow.utils.Resource

class MapViewModel(
    val apiHelper: ApiHelper,
    dbHelper: DatabaseHelper,
    val dispatcherProvider: DispatcherProvider
) : ViewModel() {

    private val _users = MutableStateFlow<Resource<List<User>>>(Resource.loading())

    val users: StateFlow<Resource<List<User>>> = _users

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch(dispatcherProvider.main) {
            _users.value = Resource.loading()
            apiHelper.getUsers()
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
                .flowOn(dispatcherProvider.io)
                .catch { e ->
                    _users.value = Resource.error(e.toString())
                }
                .collect {
                    _users.value = Resource.success(it)
                }
        }
    }

}