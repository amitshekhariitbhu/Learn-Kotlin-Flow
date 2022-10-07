package me.amitshekhar.learn.kotlin.flow.ui.retryexponentialbackoff

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.android.synthetic.main.activity_retry.*
import kotlinx.coroutines.launch
import me.amitshekhar.learn.kotlin.flow.R
import me.amitshekhar.learn.kotlin.flow.data.api.ApiHelperImpl
import me.amitshekhar.learn.kotlin.flow.data.api.RetrofitBuilder
import me.amitshekhar.learn.kotlin.flow.data.local.DatabaseBuilder
import me.amitshekhar.learn.kotlin.flow.data.local.DatabaseHelperImpl
import me.amitshekhar.learn.kotlin.flow.utils.Status
import me.amitshekhar.learn.kotlin.flow.utils.ViewModelFactory

class RetryExponentialBackoffActivity : AppCompatActivity() {

    private lateinit var viewModel: RetryExponentialBackoffModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retry)
        setupViewModel()
        setupLongRunningTask()
    }

    private fun setupLongRunningTask() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.status.collect {
                    when (it.status) {
                        Status.SUCCESS -> {
                            progressBar.visibility = View.GONE
                            textView.text = it.data
                            textView.visibility = View.VISIBLE
                        }
                        Status.LOADING -> {
                            progressBar.visibility = View.VISIBLE
                            textView.visibility = View.GONE
                        }
                        Status.ERROR -> {
                            //Handle Error
                            progressBar.visibility = View.GONE
                            Toast.makeText(
                                this@RetryExponentialBackoffActivity,
                                it.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
        }
        viewModel.startTask()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                ApiHelperImpl(RetrofitBuilder.apiService),
                DatabaseHelperImpl(DatabaseBuilder.getInstance(applicationContext))
            )
        )[RetryExponentialBackoffModel::class.java]
    }
}
