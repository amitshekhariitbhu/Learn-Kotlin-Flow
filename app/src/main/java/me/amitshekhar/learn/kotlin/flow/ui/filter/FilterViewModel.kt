package me.amitshekhar.learn.kotlin.flow.ui.filter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import me.amitshekhar.learn.kotlin.flow.data.api.ApiHelper
import me.amitshekhar.learn.kotlin.flow.data.local.DatabaseHelper
import me.amitshekhar.learn.kotlin.flow.utils.DispatcherProvider
import me.amitshekhar.learn.kotlin.flow.ui.base.UiState

class FilterViewModel(
    apiHelper: ApiHelper,
    dbHelper: DatabaseHelper,
    val dispatcherProvider: DispatcherProvider
) : ViewModel() {
    private val _status = MutableStateFlow<UiState<String>>(UiState.Loading)

    val status: StateFlow<UiState<String>> = _status

    fun startFilterTask() {
        viewModelScope.launch(dispatcherProvider.main) {
            _status.value = UiState.Loading
            val result = mutableListOf<Int>()
            (1..5).asFlow()
                .filter {
                    it % 2 == 0
                }
                .toList(result)
            _status.value = UiState.Success(result.toString())
        }
    }


}