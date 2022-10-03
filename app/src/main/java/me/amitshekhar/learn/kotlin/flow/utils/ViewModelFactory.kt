package me.amitshekhar.learn.kotlin.flow.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import me.amitshekhar.learn.kotlin.flow.data.api.ApiHelper
import me.amitshekhar.learn.kotlin.flow.data.local.DatabaseHelper
import me.amitshekhar.learn.kotlin.flow.ui.completion.CompletionViewModel
import me.amitshekhar.learn.kotlin.flow.ui.errorhandling.catch.CatchViewModel
import me.amitshekhar.learn.kotlin.flow.ui.errorhandling.emitall.EmitAllViewModel
import me.amitshekhar.learn.kotlin.flow.ui.filter.FilterViewModel
import me.amitshekhar.learn.kotlin.flow.ui.map.MapViewModel
import me.amitshekhar.learn.kotlin.flow.ui.reduce.ReduceViewModel
import me.amitshekhar.learn.kotlin.flow.ui.retrofit.parallel.ParallelNetworkCallsViewModel
import me.amitshekhar.learn.kotlin.flow.ui.retrofit.series.SeriesNetworkCallsViewModel
import me.amitshekhar.learn.kotlin.flow.ui.retrofit.single.SingleNetworkCallViewModel
import me.amitshekhar.learn.kotlin.flow.ui.retry.RetryViewModel
import me.amitshekhar.learn.kotlin.flow.ui.retryexponentialbackoff.RetryExponentialBackoffModel
import me.amitshekhar.learn.kotlin.flow.ui.retrywhen.RetryWhenViewModel
import me.amitshekhar.learn.kotlin.flow.ui.room.RoomDBViewModel
import me.amitshekhar.learn.kotlin.flow.ui.task.onetask.LongRunningTaskViewModel
import me.amitshekhar.learn.kotlin.flow.ui.task.twotasks.TwoLongRunningTasksViewModel

class ViewModelFactory(private val apiHelper: ApiHelper, private val dbHelper: DatabaseHelper) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SingleNetworkCallViewModel::class.java)) {
            return SingleNetworkCallViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(SeriesNetworkCallsViewModel::class.java)) {
            return SeriesNetworkCallsViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(ParallelNetworkCallsViewModel::class.java)) {
            return ParallelNetworkCallsViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(RoomDBViewModel::class.java)) {
            return RoomDBViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(CatchViewModel::class.java)) {
            return CatchViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(EmitAllViewModel::class.java)) {
            return EmitAllViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(LongRunningTaskViewModel::class.java)) {
            return LongRunningTaskViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(TwoLongRunningTasksViewModel::class.java)) {
            return TwoLongRunningTasksViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(CompletionViewModel::class.java)) {
            return CompletionViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(FilterViewModel::class.java)) {
            return FilterViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(MapViewModel::class.java)) {
            return MapViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(ReduceViewModel::class.java)) {
            return ReduceViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(RetryViewModel::class.java)) {
            return RetryViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(RetryWhenViewModel::class.java)) {
            return RetryWhenViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(RetryExponentialBackoffModel::class.java)) {
            return RetryExponentialBackoffModel(apiHelper, dbHelper) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}