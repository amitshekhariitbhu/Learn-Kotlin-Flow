package me.amitshekhar.learn.kotlin.flow.ui.errorhandling.catch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import me.amitshekhar.learn.kotlin.flow.data.api.ApiHelper
import me.amitshekhar.learn.kotlin.flow.data.local.DatabaseHelper
import me.amitshekhar.learn.kotlin.flow.data.model.ApiUser
import me.amitshekhar.learn.kotlin.flow.utils.DispatcherProvider
import me.amitshekhar.learn.kotlin.flow.ui.base.UiState

class CatchViewModel(
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
            apiHelper.getUsersWithError()
                .catch { e ->
                    _users.value = UiState.Error(e.toString())
                }
                .collect {
                    _users.value = UiState.Success(it)
                }
        }
    }

}