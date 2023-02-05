package me.amitshekhar.learn.kotlin.flow.ui.task.onetask

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import me.amitshekhar.learn.kotlin.flow.data.api.ApiHelper
import me.amitshekhar.learn.kotlin.flow.data.local.DatabaseHelper
import me.amitshekhar.learn.kotlin.flow.utils.DispatcherProvider
import me.amitshekhar.learn.kotlin.flow.ui.base.UiState

class LongRunningTaskViewModel(
    private val apiHelper: ApiHelper,
    private val dbHelper: DatabaseHelper,
    val dispatcherProvider: DispatcherProvider
) : ViewModel() {

    private val _status = MutableStateFlow<UiState<String>>(UiState.Loading)

    val status: StateFlow<UiState<String>> = _status

    fun startLongRunningTask() {
        viewModelScope.launch(dispatcherProvider.main) {
            _status.value = UiState.Loading
            // do a long running task
            doLongRunningTask()
                .flowOn(dispatcherProvider.default)
                .catch {
                    _status.value = UiState.Error("Something Went Wrong")
                }
                .collect {
                    _status.value = UiState.Success("Task Completed")
                }
        }
    }

    private fun doLongRunningTask(): Flow<Int> {
        return flow {
            // your code for doing a long running task
            // Added delay to simulate
            delay(5000)
            emit(0)
        }
    }
}