package me.amitshekhar.learn.kotlin.flow.ui.retrofit.series

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import me.amitshekhar.learn.kotlin.flow.data.api.ApiHelper
import me.amitshekhar.learn.kotlin.flow.data.local.DatabaseHelper
import me.amitshekhar.learn.kotlin.flow.data.model.ApiUser
import me.amitshekhar.learn.kotlin.flow.utils.DispatcherProvider
import me.amitshekhar.learn.kotlin.flow.ui.base.UiState

class SeriesNetworkCallsViewModel(
    private val apiHelper: ApiHelper,
    private val dbHelper: DatabaseHelper,
    val dispatcherProvider: DispatcherProvider
) : ViewModel() {

    private val _users = MutableStateFlow<UiState<List<ApiUser>>>(UiState.Loading)

    val users: StateFlow<UiState<List<ApiUser>>> = _users

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch(dispatcherProvider.main) {
            _users.value = UiState.Loading
            val allUsersFromApi = mutableListOf<ApiUser>()
            apiHelper.getUsers()
                .flatMapConcat { usersFromApi ->
                    allUsersFromApi.addAll(usersFromApi)
                    apiHelper.getMoreUsers()
                }
                .flowOn(dispatcherProvider.io)
                .catch { e ->
                    _users.value = UiState.Error(e.toString())
                }
                .collect { moreUsersFromApi ->
                    allUsersFromApi.addAll(moreUsersFromApi)
                    _users.value = UiState.Success(allUsersFromApi)
                }
        }
    }


}