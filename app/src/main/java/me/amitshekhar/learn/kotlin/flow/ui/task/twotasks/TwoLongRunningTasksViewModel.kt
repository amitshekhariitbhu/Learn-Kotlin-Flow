package me.amitshekhar.learn.kotlin.flow.ui.task.twotasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import me.amitshekhar.learn.kotlin.flow.data.api.ApiHelper
import me.amitshekhar.learn.kotlin.flow.data.local.DatabaseHelper
import me.amitshekhar.learn.kotlin.flow.utils.DispatcherProvider
import me.amitshekhar.learn.kotlin.flow.ui.base.UiState

class TwoLongRunningTasksViewModel(
    private val apiHelper: ApiHelper,
    private val dbHelper: DatabaseHelper,
    val dispatcherProvider: DispatcherProvider
) : ViewModel() {

    private val _status = MutableStateFlow<UiState<String>>(UiState.Loading)

    val status: StateFlow<UiState<String>> = _status

    fun startLongRunningTask() {
        viewModelScope.launch(dispatcherProvider.main) {
            _status.value = UiState.Loading
            doLongRunningTaskOne()
                .zip(doLongRunningTaskTwo()) { resultOne, resultTwo ->
                    return@zip resultOne + resultTwo
                }
                .flowOn(dispatcherProvider.default)
                .catch { e ->
                    _status.value = UiState.Error(e.toString())
                }
                .collect {
                    _status.value = UiState.Success(it)
                }
        }
    }


    private fun doLongRunningTaskTwo(): Flow<String> {
        return flow {
            // your code for doing a long running task
            // Added delay to simulate
            delay(5000)
            emit("Two")
        }
    }

    private fun doLongRunningTaskOne(): Flow<String> {
        return flow {
            // your code for doing a long running task
            // Added delay to simulate
            delay(5000)
            emit("One")
        }
    }

}