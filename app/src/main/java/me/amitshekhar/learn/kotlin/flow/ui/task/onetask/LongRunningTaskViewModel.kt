package me.amitshekhar.learn.kotlin.flow.ui.task.onetask

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import me.amitshekhar.learn.kotlin.flow.data.api.ApiHelper
import me.amitshekhar.learn.kotlin.flow.data.local.DatabaseHelper
import me.amitshekhar.learn.kotlin.flow.utils.Resource

class LongRunningTaskViewModel(
    private val apiHelper: ApiHelper,
    private val dbHelper: DatabaseHelper
) : ViewModel() {

    private val _status = MutableStateFlow<Resource<String>>(Resource.loading())

    val status: StateFlow<Resource<String>> = _status

    fun startLongRunningTask() {
        viewModelScope.launch {
            _status.value = Resource.loading()
            // do a long running task
            doLongRunningTask()
                .flowOn(Dispatchers.Default)
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
            // Added delay to simulate
            delay(5000)
            emit(0)
        }
    }
}