<img src=https://raw.githubusercontent.com/amitshekhariitbhu/Learn-Kotlin-Flow/main/assets/learn-kotlin-flow.png >

# Learn Kotlin Flow by real examples for Android

## About this project:

* This project is for someone who wants to get started with Kotlin Flow.
* I have tried to add the examples we implement in our Android project frequently.

## What is Flow?

**Flow is an asynchronous data stream(which generally comes from a task) that emits values to the
collector and gets completed with or without an exception.**

This will make more sense when we go through the example. Let's take a standard example of image
downloading.

**Assume that we have a task:** To download an image, emit the items(values) which are the
percentage of the image downloading like 1%, 2%, 3%, and so on. It can get completed with or without
an exception. If everything goes well, the task will be completed without an exception. But, in case
of network failure, the task will be completed with an exception.

So, there will be a task that will be done and will emit some values which will be collected by the
collector.

Now, let's discuss the major components of Flow.

The major components of Flow are as below:

- Flow Builder
- Operator
- Collector

Let's understand this with the following analogy.

|  Component    |    Analogy    |
| ------------- | ------------- |
| Flow Builder  |   Speaker     |
| Operator      |   Translator  |
| Collector     |   Listener    |

### Flow Builder

In simple words, we can say that it helps in doing a task and emitting items. Sometimes it is just
required to emit the items without doing any task, for example, just emit a few numbers (1, 2, 3).
Here, the flow builder helps us in doing so. We can think of this as a **Speaker**. The Speaker will
think(do a task) and speak(emit items).

### Operator

The operator helps in transforming the data from one format to another.

We can think of the operator as a **Translator**. Assume that the Speaker is speaking in French and
the Collector(Listener) understands English only. So, there has to be a translator to translate
French into English. That translator is an Operator.

Operators are more than this actually, using the operator, we can also provide the thread on which
the task will be done. We will see this later.

### Collector

The collector collects the items emitted using the Flow Builder which are transformed by the
operators.

We can think of a collector as a **Listener**. Actually, Collector also comes under the operator
which is known as Terminal Operator. The collector is a Terminal Operator.

**Flow API Source Code**

The Flow interfaces look like the below in the source code of Coroutines:

```kotlin
public fun interface FlowCollector<in T> {

    public suspend fun emit(value: T)

}
```

```kotlin
public interface Flow<out T> {

    public suspend fun collect(collector: FlowCollector<T>)

}
```

## Hello World of Flow

```kotlin
flow {
    (0..10).forEach {
        emit(it)
    }
}.map {
    it * it
}.collect {
    Log.d(TAG, it.toString())
}
```

|   Code Block  |   Component   |
| ------------- | ------------- |
| `flow { }`    |  Flow Builder |
|  `map { }`    |  Operator     |
| `collect {}`  |  Collector    |

Let's go through the code.

- First, we have a flow builder which is emitting 0 to 10.
- Then, we have a map operator which will take each and every value and square(it \* it). The map is
  Intermediate Operator.
- Then, we have a collector in which we get the emitted values and print them as 0, 1, 4, 9, 16, 25,
  36, 49, 64, 81, 100.

**Note: When we actually connect both the Flow Builder and the Collector using the collect method,
then only, it will start executing.**

Now we have understood what exactly Flow is.

## Steps to learn Kotlin Flow from this project

* Learn about the Kotlin Flow from this **[blog](https://amitshekhar.me/blog/flow-api-in-kotlin)**
* Long-running tasks in parallel with Kotlin Flow [Long-running tasks in parallel with Kotlin Flow](https://amitshekhar.me/blog/long-running-tasks-in-parallel-with-kotlin-flow)
* Retry Operator in Kotlin Flow [Retry Operator in Kotlin Flow](https://amitshekhar.me/blog/retry-operator-in-kotlin-flow)
* Retrofit with Kotlin Flow [Retrofit with Kotlin Flow](https://amitshekhar.me/blog/retrofit-with-kotlin-flow)
* Room Database with Kotlin Flow [Room Database with Kotlin Flow](https://amitshekhar.me/blog/room-database-with-kotlin-flow)
* Creating Flow Using Flow Builder in Kotlin [Creating Flow Using Flow Builder in Kotlin](https://amitshekhar.me/blog/creating-flow-using-flow-builder-in-kotlin)
* Terminal Operators in Kotlin Flow [Terminal Operators in Kotlin Flow](https://amitshekhar.me/blog/terminal-operators-in-kotlin-flow)
* Kotlin Flow Zip Operator for Parallel Multiple Network Calls [Kotlin Flow Zip Operator for Parallel Multiple Network Calls](https://amitshekhar.me/blog/kotlin-flow-zip-operator-parallel-multiple-network-calls)
* Instant Search Using Kotlin Flow Operators [Instant Search Using Kotlin Flow Operators](https://amitshekhar.me/blog/instant-search-using-kotlin-flow-operators)
* Exception Handling in Kotlin Flow [Exception Handling in Kotlin Flow](https://amitshekhar.me/blog/exception-handling-in-kotlin-flow)
* Then, just clone, build, run the project and start learning Kotlin Flow by examples.

## You will learn the following from this Learn Kotlin Flow project:

* How to use Kotlin Flow in Android Project?
* Doing simple task in background using Kotlin Flow.
* Doing tasks in series using Kotlin Flow.
* Doing tasks in parallel using Kotlin Flow. [Blog](https://amitshekhar.me/blog/long-running-tasks-in-parallel-with-kotlin-flow)
* Making two network calls in parallel using Kotlin Flow.
* Using operators like filter, map, reduce, flatMapConcat, zip, and etc.
* Exception handling in Kotlin Flow
* How to use onCompletion in Flow?
* Retry Task using retry operator in Flow. Blog: [Retry Operator in Kotlin Flow](https://amitshekhar.me/blog/retry-operator-in-kotlin-flow)
* Retry Task with Exponential Backoff in Flow. Blog: [Retry Operator in Kotlin Flow](https://amitshekhar.me/blog/retry-operator-in-kotlin-flow)
* Using Kotlin Flow with Retrofit. [Blog](https://amitshekhar.me/blog/retrofit-with-kotlin-flow)
* Using Kotlin Flow with Room
  Database. [Blog](https://amitshekhar.me/blog/room-database-with-kotlin-flow)
* Using Kotlin Flow with various 3rd party libraries.
* Making two network calls in parallel using Kotlin Flow.
* Doing task in series using Kotlin Flow.
* Writing Unit-Test for ViewModel which uses Kotlin Flow. Blog: [Unit Testing ViewModel with Kotlin Flow and StateFlow](https://amitshekhar.me/blog/unit-testing-viewmodel-with-kotlin-flow-and-stateflow)

## Kotlin Flow Examples for Android Development: Activity and ViewModel

* **Single Network Call:** Learn how to make a network call using Kotlin Flow. This is a very simple
  use-case in Android App Development.
  Blog: [Retrofit with Kotlin Flow](https://amitshekhar.me/blog/retrofit-with-kotlin-flow)
    * [Activity Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/retrofit/single/SingleNetworkCallActivity.kt)
    * [ViewModel Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/retrofit/single/SingleNetworkCallViewModel.kt)

* **Series Network Calls:** Learn how to make network calls in series using Kotlin Flow. This is
  useful when you want to make a network call which is dependent on an another network call.
    * [Activity Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/retrofit/series/SeriesNetworkCallsActivity.kt)
    * [ViewModel Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/retrofit/series/SeriesNetworkCallsViewModel.kt)

* **Parallel Network Calls:** Learn how to make network calls in parallel using Kotlin Flow. This is
  useful when you want to make network calls in parallel which are independent of each other.
    * [Activity Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/retrofit/parallel/ParallelNetworkCallsActivity.kt)
    * [ViewModel Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/retrofit/parallel/ParallelNetworkCallsViewModel.kt)

* **Room Database Operation:** Learn how to fetch or insert entity in database using Kotlin Flow.
  This is useful when you are using Room Database in your Android Application.
  Blog: [Room Database with Kotlin Flow](https://amitshekhar.me/blog/room-database-with-kotlin-flow)
    * [Activity Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/room/RoomDBActivity.kt)
    * [ViewModel Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/room/RoomDBViewModel.kt)

* **Long Running Task:** Learn how to run a long running task using Kotlin Flow. If you want to do
  any of your task in background thread using the Kotlin Flow, then this is useful.
    * [Activity Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/task/onetask/LongRunningTaskActivity.kt)
    * [ViewModel Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/task/onetask/LongRunningTaskViewModel.kt)

* **Two Long Running Tasks:** Learn how to run two long running tasks in parallel using Kotlin Flow. Blog: [Long-running tasks in parallel with Kotlin Flow](https://amitshekhar.me/blog/long-running-tasks-in-parallel-with-kotlin-flow)
    * [Activity Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/task/twotasks/TwoLongRunningTasksActivity.kt)
    * [ViewModel Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/task/twotasks/TwoLongRunningTasksViewModel.kt)

* **Catch Error Handling:** Learn how to handle error in Kotlin Flow using Catch.
    * [Activity Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/errorhandling/catch/CatchActivity.kt)
    * [ViewModel Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/errorhandling/catch/CatchViewModel.kt)

* **EmitAll Error Handling:** Learn how to handle error in Kotlin Flow using emitAll.
    * [Activity Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/errorhandling/emitall/EmitAllActivity.kt)
    * [ViewModel Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/errorhandling/emitall/EmitAllViewModel.kt)

* **Completion:**
    * [Activity Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/completion/CompletionActivity.kt)
    * [ViewModel Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/completion/CompletionViewModel.kt)

* **Reduce:**
    * [Activity Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/reduce/ReduceActivity.kt)
    * [ViewModel Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/reduce/ReduceViewModel.kt)

* **Map:**
    * [Activity Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/map/MapActivity.kt)
    * [ViewModel Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/map/MapViewModel.kt)

* **Filter:**
    * [Activity Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/filter/FilterActivity.kt)
    * [ViewModel Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/filter/FilterViewModel.kt)

* **Search Feature:** Implement Search Using Kotlin Flow Operators - Debounce, Filter,
  DistinctUntilChanged, FlatMapLatest.
    * [Activity Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/search/SearchActivity.kt)

* **Retry:** Blog: [Retry Operator in Kotlin Flow](https://amitshekhar.me/blog/retry-operator-in-kotlin-flow)
    * [Activity Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/retry/RetryActivity.kt)
    * [ViewModel Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/retry/RetryViewModel.kt)

* **RetryWhen:** Blog: [Retry Operator in Kotlin Flow](https://amitshekhar.me/blog/retry-operator-in-kotlin-flow)
    * [Activity Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/retrywhen/RetryWhenActivity.kt)
    * [ViewModel Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/retrywhen/RetryWhenViewModel.kt)

* **Retry with Exponential Backoff:** Blog: [Retry Operator in Kotlin Flow](https://amitshekhar.me/blog/retry-operator-in-kotlin-flow)
    * [Activity Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/retryexponentialbackoff/RetryExponentialBackoffActivity.kt)
    * [ViewModel Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/retryexponentialbackoff/RetryExponentialBackoffModel.kt)

* **Unit Test:** Learn how write unit-test for ViewModel which uses Kotlin Flow.
    * [ViewModelTest Code](app/src/test/java/me/amitshekhar/learn/kotlin/flow/ui/retrofit/single/SingleNetworkCallViewModelTest.kt)

## If this project helps you in anyway, show your love :heart: by putting a :star: on this project :v:

### License

```
   Copyright (C) 2022 Amit Shekhar

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```

### Contributing to Learn Kotlin Flow

Just make pull request. You are in!

Thanks

[**Amit Shekhar**](https://amitshekhar.me)

You can connect with me on:

- [Twitter](https://twitter.com/amitiitbhu)
- [LinkedIn](https://www.linkedin.com/in/amit-shekhar-iitbhu)
- [GitHub](https://github.com/amitshekhariitbhu)
- [Facebook](https://www.facebook.com/amit.shekhar.iitbhu)

[**Read all of my blogs here.**](https://amitshekhar.me/blog)
