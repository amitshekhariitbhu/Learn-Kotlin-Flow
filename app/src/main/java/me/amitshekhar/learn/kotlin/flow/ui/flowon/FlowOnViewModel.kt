package me.amitshekhar.learn.kotlin.flow.ui.flowon

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import me.amitshekhar.learn.kotlin.flow.data.api.ApiHelper
import me.amitshekhar.learn.kotlin.flow.data.local.DatabaseHelper
import me.amitshekhar.learn.kotlin.flow.utils.DispatcherProvider

class FlowOnViewModel(
    val apiHelper: ApiHelper, dbHelper: DatabaseHelper, val dispatcherProvider: DispatcherProvider
) : ViewModel() {

    companion object {
        private const val TAG = "FlowOnViewModel"
    }


    fun startFlowOnTask() {
        viewModelScope.launch(dispatcherProvider.main) {
            doLongRunningTask()
                .flowOn(dispatcherProvider.default)
                .filter {
                    printThreadName("filter 1")
                    return@filter true
                }
                .map {
                    printThreadName("map 1")
                    return@map it * it
                }
                .flowOn(dispatcherProvider.default)
                .filter {
                    printThreadName("filter 2")
                    return@filter true
                }
                .flowOn(dispatcherProvider.main)
                .map {
                    printThreadName("map 2")
                    return@map it * it
                }
                .flowOn(dispatcherProvider.default)
                .filter {
                    printThreadName("filter 3")
                    return@filter true
                }
                .map {
                    printThreadName("map 3")
                    return@map it * it
                }
                .collect {
                    printThreadName("collect")
                }
        }
    }

    private fun doLongRunningTask(): Flow<Int> {
        return flow {
            // your code for doing a long running task
            // Added delay to simulate
            printThreadName("doLongRunningTask")
            delay(2000)
            emit(2)
        }
    }

    private fun printThreadName(src: String) {
        Log.d(TAG, src + " : " + Thread.currentThread().name)
    }

}