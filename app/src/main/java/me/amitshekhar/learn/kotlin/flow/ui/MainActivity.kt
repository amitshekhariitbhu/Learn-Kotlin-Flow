package me.amitshekhar.learn.kotlin.flow.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import me.amitshekhar.learn.kotlin.flow.R
import me.amitshekhar.learn.kotlin.flow.ui.completion.CompletionActivity
import me.amitshekhar.learn.kotlin.flow.ui.errorhandling.catch.CatchActivity
import me.amitshekhar.learn.kotlin.flow.ui.errorhandling.emitall.EmitAllActivity
import me.amitshekhar.learn.kotlin.flow.ui.filter.FilterActivity
import me.amitshekhar.learn.kotlin.flow.ui.flowon.FlowOnActivity
import me.amitshekhar.learn.kotlin.flow.ui.map.MapActivity
import me.amitshekhar.learn.kotlin.flow.ui.reduce.ReduceActivity
import me.amitshekhar.learn.kotlin.flow.ui.retrofit.parallel.ParallelNetworkCallsActivity
import me.amitshekhar.learn.kotlin.flow.ui.retrofit.series.SeriesNetworkCallsActivity
import me.amitshekhar.learn.kotlin.flow.ui.retrofit.single.SingleNetworkCallActivity
import me.amitshekhar.learn.kotlin.flow.ui.retry.RetryActivity
import me.amitshekhar.learn.kotlin.flow.ui.retryexponentialbackoff.RetryExponentialBackoffActivity
import me.amitshekhar.learn.kotlin.flow.ui.retrywhen.RetryWhenActivity
import me.amitshekhar.learn.kotlin.flow.ui.room.RoomDBActivity
import me.amitshekhar.learn.kotlin.flow.ui.search.SearchActivity
import me.amitshekhar.learn.kotlin.flow.ui.task.onetask.LongRunningTaskActivity
import me.amitshekhar.learn.kotlin.flow.ui.task.twotasks.TwoLongRunningTasksActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startSingleNetworkCallActivity(view: View) {
        startActivity(Intent(this@MainActivity, SingleNetworkCallActivity::class.java))
    }

    fun startSeriesNetworkCallsActivity(view: View) {
        startActivity(Intent(this@MainActivity, SeriesNetworkCallsActivity::class.java))
    }

    fun startParallelNetworkCallsActivity(view: View) {
        startActivity(Intent(this@MainActivity, ParallelNetworkCallsActivity::class.java))
    }

    fun startRoomDatabaseActivity(view: View) {
        startActivity(Intent(this@MainActivity, RoomDBActivity::class.java))
    }

    fun startCatchActivity(view: View) {
        startActivity(Intent(this@MainActivity, CatchActivity::class.java))
    }

    fun startEmitAllActivity(view: View) {
        startActivity(Intent(this@MainActivity, EmitAllActivity::class.java))
    }

    fun startCompletionActivity(view: View) {
        startActivity(Intent(this@MainActivity, CompletionActivity::class.java))
    }

    fun startLongRunningTaskActivity(view: View) {
        startActivity(Intent(this@MainActivity, LongRunningTaskActivity::class.java))
    }

    fun startTwoLongRunningTasksActivity(view: View) {
        startActivity(Intent(this@MainActivity, TwoLongRunningTasksActivity::class.java))
    }

    fun startFilterActivity(view: View) {
        startActivity(Intent(this@MainActivity, FilterActivity::class.java))
    }

    fun startMapActivity(view: View) {
        startActivity(Intent(this@MainActivity, MapActivity::class.java))
    }

    fun startReduceActivity(view: View) {
        startActivity(Intent(this@MainActivity, ReduceActivity::class.java))
    }

    fun startSearchActivity(view: View) {
        startActivity(Intent(this@MainActivity, SearchActivity::class.java))
    }

    fun startRetryActivity(view: View) {
        startActivity(Intent(this@MainActivity, RetryActivity::class.java))
    }

    fun startRetryWhenActivity(view: View) {
        startActivity(Intent(this@MainActivity, RetryWhenActivity::class.java))
    }

    fun startRetryExponentialBackoffActivity(view: View) {
        startActivity(Intent(this@MainActivity, RetryExponentialBackoffActivity::class.java))
    }

    fun startFlowOnActivity(view: View) {
        startActivity(Intent(this@MainActivity, FlowOnActivity::class.java))
    }

}
