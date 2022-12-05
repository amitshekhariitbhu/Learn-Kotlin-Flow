package me.amitshekhar.learn.kotlin.flow.ui.retryexponentialbackoff

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import me.amitshekhar.learn.kotlin.flow.data.api.ApiHelper
import me.amitshekhar.learn.kotlin.flow.data.local.DatabaseHelper
import me.amitshekhar.learn.kotlin.flow.utils.DispatcherProvider
import me.amitshekhar.learn.kotlin.flow.utils.Resource
import java.io.IOException

class RetryExponentialBackoffModel(
    val apiHelper: ApiHelper,
    dbHelper: DatabaseHelper,
    val dispatcherProvider: DispatcherProvider
) : ViewModel() {

    private val _status = MutableStateFlow<Resource<String>>(Resource.loading())

    val status: StateFlow<Resource<String>> = _status

    fun startTask() {
        viewModelScope.launch(dispatcherProvider.main) {
            _status.value = Resource.loading()
            // do a long running task
            var currentDelay = 1000L
            val delayFactor = 2
            doLongRunningTask()
                .flowOn(dispatcherProvider.default)
                .retry(retries = 3) { cause ->
                    if (cause is IOException) {
                        delay(currentDelay)
                        currentDelay = (currentDelay * delayFactor)
                        return@retry true
                    } else {
                        return@retry false
                    }
                }
                .catch {
                    _status.value = Resource.error("Something Went Wrong")
                }
                .collect {
                    _status.value = Resource.success("Task Completed")
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