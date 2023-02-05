package me.amitshekhar.learn.kotlin.flow.ui.retry

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import me.amitshekhar.learn.kotlin.flow.data.api.ApiHelper
import me.amitshekhar.learn.kotlin.flow.data.local.DatabaseHelper
import me.amitshekhar.learn.kotlin.flow.utils.DispatcherProvider
import me.amitshekhar.learn.kotlin.flow.ui.base.UiState
import java.io.IOException

class RetryViewModel(
    val apiHelper: ApiHelper,
    dbHelper: DatabaseHelper,
    val dispatcherProvider: DispatcherProvider
) : ViewModel() {

    private val _status = MutableStateFlow<UiState<String>>(UiState.Loading)

    val status: StateFlow<UiState<String>> = _status

    fun startTask() {
        viewModelScope.launch(dispatcherProvider.main) {
            _status.value = UiState.Loading
            // do a long running task
            doLongRunningTask()
                .flowOn(dispatcherProvider.default)
                .retry(retries = 3) { cause ->
                    if (cause is IOException) {
                        delay(2000)
                        return@retry true
                    } else {
                        return@retry false
                    }
                }
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
            // Added delay, random number, and exception to simulate

            delay(2000)

            val randomNumber = (0..2).random()

            if (randomNumber == 0) {
                throw IOException()
            } else if (randomNumber == 1) {
                throw IndexOutOfBoundsException()
            }

            delay(2000)
            emit(0)
        }
    }

}