package me.amitshekhar.learn.kotlin.flow.ui.retrywhen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import me.amitshekhar.learn.kotlin.flow.data.api.ApiHelper
import me.amitshekhar.learn.kotlin.flow.data.local.DatabaseHelper
import me.amitshekhar.learn.kotlin.flow.utils.Resource
import java.io.IOException

class RetryWhenViewModel(
    val apiHelper: ApiHelper,
    dbHelper: DatabaseHelper
) : ViewModel() {

    private val _status = MutableStateFlow<Resource<String>>(Resource.loading())

    val status: StateFlow<Resource<String>> = _status

    fun startTask() {
        viewModelScope.launch {
            _status.value = Resource.loading()
            // do a long running task
            doLongRunningTask()
                .flowOn(Dispatchers.Default)
                .retryWhen { cause, attempt ->
                    if (cause is IOException && attempt < 3) {
                        delay(2000)
                        return@retryWhen true
                    } else {
                        return@retryWhen false
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