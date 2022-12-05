package me.amitshekhar.learn.kotlin.flow.ui.task.twotasks

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

class TwoLongRunningTasksViewModel(
    private val apiHelper: ApiHelper,
    private val dbHelper: DatabaseHelper,
    val dispatcherProvider: DispatcherProvider
) : ViewModel() {

    private val _status = MutableStateFlow<Resource<String>>(Resource.loading())

    val status: StateFlow<Resource<String>> = _status

    fun startLongRunningTask() {
        viewModelScope.launch(dispatcherProvider.main) {
            _status.value = Resource.loading()
            doLongRunningTaskOne()
                .zip(doLongRunningTaskTwo()) { resultOne, resultTwo ->
                    return@zip resultOne + resultTwo
                }
                .flowOn(dispatcherProvider.default)
                .catch { e ->
                    _status.value = Resource.error(e.toString())
                }
                .collect {
                    _status.value = Resource.success(it)
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