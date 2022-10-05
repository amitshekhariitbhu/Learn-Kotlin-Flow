package me.amitshekhar.learn.kotlin.flow.ui.completion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.launch
import me.amitshekhar.learn.kotlin.flow.data.api.ApiHelper
import me.amitshekhar.learn.kotlin.flow.data.local.DatabaseHelper
import me.amitshekhar.learn.kotlin.flow.utils.Resource

class CompletionViewModel(
    private val apiHelper: ApiHelper,
    private val dbHelper: DatabaseHelper
) : ViewModel() {

    private val _status = MutableStateFlow<Resource<String>>(Resource.loading())

    val status: StateFlow<Resource<String>> = _status

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            _status.value = Resource.loading()
            apiHelper.getUsers()
                .catch { e ->
                    _status.value = Resource.error(e.toString())
                }
                .onCompletion {
                    _status.value = Resource.success("Task Completed")
                }
                .collect {
                }
        }
    }

}