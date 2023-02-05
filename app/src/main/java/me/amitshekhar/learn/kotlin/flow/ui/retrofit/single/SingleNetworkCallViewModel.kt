package me.amitshekhar.learn.kotlin.flow.ui.retrofit.single

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import me.amitshekhar.learn.kotlin.flow.data.api.ApiHelper
import me.amitshekhar.learn.kotlin.flow.data.local.DatabaseHelper
import me.amitshekhar.learn.kotlin.flow.data.model.ApiUser
import me.amitshekhar.learn.kotlin.flow.utils.DispatcherProvider
import me.amitshekhar.learn.kotlin.flow.ui.base.UiState

class SingleNetworkCallViewModel(
    private val apiHelper: ApiHelper,
    private val dbHelper: DatabaseHelper,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<ApiUser>>>(UiState.Loading)

    val uiState: StateFlow<UiState<List<ApiUser>>> = _uiState

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch(dispatcherProvider.main) {
            _uiState.value = UiState.Loading
            apiHelper.getUsers()
                .flowOn(dispatcherProvider.io)
                .catch { e ->
                    _uiState.value = UiState.Error(e.toString())
                }
                .collect {
                    _uiState.value = UiState.Success(it)
                }
        }
    }

}