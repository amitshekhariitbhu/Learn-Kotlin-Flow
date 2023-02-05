package me.amitshekhar.learn.kotlin.flow.ui.filter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import me.amitshekhar.learn.kotlin.flow.data.api.ApiHelper
import me.amitshekhar.learn.kotlin.flow.data.local.DatabaseHelper
import me.amitshekhar.learn.kotlin.flow.ui.base.UiState
import me.amitshekhar.learn.kotlin.flow.utils.DispatcherProvider

class FilterViewModel(
    apiHelper: ApiHelper,
    dbHelper: DatabaseHelper,
    val dispatcherProvider: DispatcherProvider
) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState<String>>(UiState.Loading)

    val uiState: StateFlow<UiState<String>> = _uiState

    fun startFilterTask() {
        viewModelScope.launch(dispatcherProvider.main) {
            _uiState.value = UiState.Loading
            val result = mutableListOf<Int>()
            (1..5).asFlow()
                .filter {
                    it % 2 == 0
                }
                .toList(result)
            _uiState.value = UiState.Success(result.toString())
        }
    }


}