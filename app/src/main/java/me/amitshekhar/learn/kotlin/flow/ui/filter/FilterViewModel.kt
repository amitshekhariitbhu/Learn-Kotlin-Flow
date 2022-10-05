package me.amitshekhar.learn.kotlin.flow.ui.filter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import me.amitshekhar.learn.kotlin.flow.data.api.ApiHelper
import me.amitshekhar.learn.kotlin.flow.data.local.DatabaseHelper
import me.amitshekhar.learn.kotlin.flow.utils.Resource

class FilterViewModel(
    apiHelper: ApiHelper,
    dbHelper: DatabaseHelper
) : ViewModel() {
    private val _status = MutableStateFlow<Resource<String>>(Resource.loading())

    val status: StateFlow<Resource<String>> = _status

    fun startFilterTask() {
        viewModelScope.launch {
            _status.value = Resource.loading()
            val result = mutableListOf<Int>()
            (1..5).asFlow()
                .filter {
                    it % 2 == 0
                }
                .toList(result)
            _status.value = Resource.success(result.toString())
        }
    }


}