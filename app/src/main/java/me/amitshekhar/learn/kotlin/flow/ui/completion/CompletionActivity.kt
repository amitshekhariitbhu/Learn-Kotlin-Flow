package me.amitshekhar.learn.kotlin.flow.ui.completion

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_long_running_task.*
import kotlinx.android.synthetic.main.activity_recycler_view.progressBar
import kotlinx.coroutines.launch
import me.amitshekhar.learn.kotlin.flow.R
import me.amitshekhar.learn.kotlin.flow.data.api.ApiHelperImpl
import me.amitshekhar.learn.kotlin.flow.data.api.RetrofitBuilder
import me.amitshekhar.learn.kotlin.flow.data.local.DatabaseBuilder
import me.amitshekhar.learn.kotlin.flow.data.local.DatabaseHelperImpl
import me.amitshekhar.learn.kotlin.flow.ui.base.ApiUserAdapter
import me.amitshekhar.learn.kotlin.flow.utils.Status
import me.amitshekhar.learn.kotlin.flow.utils.ViewModelFactory

class CompletionActivity : AppCompatActivity() {

    private lateinit var viewModel: CompletionViewModel
    private lateinit var adapter: ApiUserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_completion)
        setupViewModel()
        setupObserver()
    }

    private fun setupObserver() {
        lifecycleScope.launch {
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
                        Toast.makeText(this@CompletionActivity, it.message, Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                ApiHelperImpl(RetrofitBuilder.apiService),
                DatabaseHelperImpl(DatabaseBuilder.getInstance(applicationContext))
            )
        )[CompletionViewModel::class.java]
    }
}