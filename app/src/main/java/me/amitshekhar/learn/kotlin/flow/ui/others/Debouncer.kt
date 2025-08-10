package me.amitshekhar.learn.kotlin.flow.ui.others

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// How to Implement Debounce Using Coroutines?

class Debouncer(private val scope: CoroutineScope, private val waitTime: Long) {

    private var job: Job? = null

    fun post(block: () -> Unit) {
        job?.cancel()
        job = scope.launch {
            delay(waitTime)
            block()
        }
    }
}

fun main() = runBlocking {
    val debouncer = Debouncer(scope = this, waitTime = 300L)
    debouncer.post { println("Outcome School 1") }
    delay(100)
    debouncer.post { println("Outcome School 2") }
    delay(400)
    debouncer.post { println("Outcome School 3") }
    delay(200)
    debouncer.post { println("Outcome School 4") }
    delay(500)
}

/*
Output:
Outcome School 2
Outcome School 4
*/
