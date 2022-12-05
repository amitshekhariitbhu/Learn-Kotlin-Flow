package me.amitshekhar.learn.kotlin.flow.ui.retrofit.series

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import me.amitshekhar.learn.kotlin.flow.data.api.ApiHelper
import me.amitshekhar.learn.kotlin.flow.data.local.DatabaseHelper
import me.amitshekhar.learn.kotlin.flow.data.model.ApiUser
import me.amitshekhar.learn.kotlin.flow.utils.DispatcherProvider
import me.amitshekhar.learn.kotlin.flow.utils.Resource

class SeriesNetworkCallsViewModel(
    private val apiHelper: ApiHelper,
    private val dbHelper: DatabaseHelper,
    val dispatcherProvider: DispatcherProvider
) : ViewModel() {

    private val _users = MutableStateFlow<Resource<List<ApiUser>>>(Resource.loading())

    val users: StateFlow<Resource<List<ApiUser>>> = _users

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch(dispatcherProvider.main) {
            _users.value = Resource.loading()
            val allUsersFromApi = mutableListOf<ApiUser>()
            apiHelper.getUsers()
                .flatMapConcat { usersFromApi ->
                    allUsersFromApi.addAll(usersFromApi)
                    apiHelper.getMoreUsers()
                }
                .flowOn(dispatcherProvider.io)
                .catch { e ->
                    _users.value = Resource.error(e.toString())
                }
                .collect { moreUsersFromApi ->
                    allUsersFromApi.addAll(moreUsersFromApi)
                    _users.value = Resource.success(allUsersFromApi)
                }
        }
    }


}