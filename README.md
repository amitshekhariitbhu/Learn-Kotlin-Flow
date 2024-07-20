<img src=https://raw.githubusercontent.com/amitshekhariitbhu/Learn-Kotlin-Flow/main/assets/learn-kotlin-flow.png >

# Learn Kotlin Flow by real examples for Android

## About this project:

* This project is for someone who wants to get started with Kotlin Flow.
* I have tried to add the examples we implement in our Android project frequently.

## About me

Hi, I am Amit Shekhar, Co-Founder @ [Outcome School](https://outcomeschool.com) • IIT 2010-14 • I have taught and mentored many developers, and their efforts landed them high-paying tech jobs, helped many tech companies in solving their unique problems, and created many open-source libraries being used by top companies. I am passionate about sharing knowledge through open-source, blogs, and videos.

You can connect with me on:

- [Twitter](https://twitter.com/amitiitbhu)
- [YouTube](https://www.youtube.com/@amitshekhar)
- [LinkedIn](https://www.linkedin.com/in/amit-shekhar-iitbhu)
- [GitHub](https://github.com/amitshekhariitbhu)

## Steps to learn Kotlin Flow from this project

First, we need to learn the concepts. 

I have written a series of blogs on **Flow API in Kotlin**:

- [Mastering Flow API in Kotlin](https://outcomeschool.com/blog/flow-api-in-kotlin)
- [Creating Flow Using Flow Builder in Kotlin](https://outcomeschool.com/blog/creating-flow-using-flow-builder-in-kotlin)
- [Terminal Operators in Kotlin Flow](https://outcomeschool.com/blog/terminal-operators-in-kotlin-flow)
- [Cold Flow vs Hot Flow](https://outcomeschool.com/blog/cold-flow-vs-hot-flow)
- [StateFlow and SharedFlow](https://outcomeschool.com/blog/stateflow-and-sharedflow)
- [Long-running tasks in parallel with Kotlin Flow](https://outcomeschool.com/blog/long-running-tasks-in-parallel-with-kotlin-flow)
- [Retry Operator in Kotlin Flow](https://outcomeschool.com/blog/retry-operator-in-kotlin-flow)
- [Retrofit with Kotlin Flow](https://outcomeschool.com/blog/retrofit-with-kotlin-flow)
- [Room Database with Kotlin Flow](https://outcomeschool.com/blog/room-database-with-kotlin-flow)
- [Kotlin Flow Zip Operator for Parallel Multiple Network Calls](https://outcomeschool.com/blog/kotlin-flow-zip-operator-parallel-multiple-network-calls)
- [Instant Search Using Kotlin Flow Operators](https://outcomeschool.com/blog/instant-search-using-kotlin-flow-operators)
- [callbackFlow - Callback to Flow API in Kotlin](https://outcomeschool.com/blog/callback-to-flow-api-in-kotlin)
- [Exception Handling in Kotlin Flow](https://outcomeschool.com/blog/exception-handling-in-kotlin-flow)
- [Unit Testing ViewModel with Kotlin Flow and StateFlow](https://outcomeschool.com/blog/unit-testing-viewmodel-with-kotlin-flow-and-stateflow)

Then, just clone, build, run the project and start learning Kotlin Flow by examples.

## You will learn the following from this Learn Kotlin Flow project:

* How to use Kotlin Flow in Android Project?
* Doing simple task in background using Kotlin Flow.
* Doing tasks in series using Kotlin Flow.
* Doing tasks in parallel using Kotlin Flow. [Blog](https://outcomeschool.com/blog/long-running-tasks-in-parallel-with-kotlin-flow)
* Making two network calls in parallel using Kotlin Flow.
* Using operators like filter, map, reduce, flatMapConcat, zip, and etc.
* Exception handling in Kotlin Flow
* How to use onCompletion in Flow?
* Retry Task using retry operator in Flow. Blog: [Retry Operator in Kotlin Flow](https://outcomeschool.com/blog/retry-operator-in-kotlin-flow)
* Retry Task with Exponential Backoff in Flow. Blog: [Retry Operator in Kotlin Flow](https://outcomeschool.com/blog/retry-operator-in-kotlin-flow)
* Using Kotlin Flow with Retrofit. [Blog](https://outcomeschool.com/blog/retrofit-with-kotlin-flow)
* Using Kotlin Flow with Room
  Database. [Blog](https://outcomeschool.com/blog/room-database-with-kotlin-flow)
* Using Kotlin Flow with various 3rd party libraries.
* Making two network calls in parallel using Kotlin Flow.
* Doing task in series using Kotlin Flow.
* Writing Unit-Test for ViewModel which uses Kotlin Flow. Blog: [Unit Testing ViewModel with Kotlin Flow and StateFlow](https://outcomeschool.com/blog/unit-testing-viewmodel-with-kotlin-flow-and-stateflow)

## Kotlin Flow Examples for Android Development: Activity and ViewModel

* **Single Network Call:** Learn how to make a network call using Kotlin Flow. This is a very simple
  use-case in Android App Development.
  Blog: [Retrofit with Kotlin Flow](https://outcomeschool.com/blog/retrofit-with-kotlin-flow)
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
  Blog: [Room Database with Kotlin Flow](https://outcomeschool.com/blog/room-database-with-kotlin-flow)
    * [Activity Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/room/RoomDBActivity.kt)
    * [ViewModel Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/room/RoomDBViewModel.kt)

* **Long Running Task:** Learn how to run a long running task using Kotlin Flow. If you want to do
  any of your task in background thread using the Kotlin Flow, then this is useful.
    * [Activity Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/task/onetask/LongRunningTaskActivity.kt)
    * [ViewModel Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/task/onetask/LongRunningTaskViewModel.kt)

* **Two Long Running Tasks:** Learn how to run two long running tasks in parallel using Kotlin Flow. Blog: [Long-running tasks in parallel with Kotlin Flow](https://outcomeschool.com/blog/long-running-tasks-in-parallel-with-kotlin-flow)
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

* **Retry:** Blog: [Retry Operator in Kotlin Flow](https://outcomeschool.com/blog/retry-operator-in-kotlin-flow)
    * [Activity Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/retry/RetryActivity.kt)
    * [ViewModel Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/retry/RetryViewModel.kt)

* **RetryWhen:** Blog: [Retry Operator in Kotlin Flow](https://outcomeschool.com/blog/retry-operator-in-kotlin-flow)
    * [Activity Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/retrywhen/RetryWhenActivity.kt)
    * [ViewModel Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/retrywhen/RetryWhenViewModel.kt)

* **Retry with Exponential Backoff:** Blog: [Retry Operator in Kotlin Flow](https://outcomeschool.com/blog/retry-operator-in-kotlin-flow)
    * [Activity Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/retryexponentialbackoff/RetryExponentialBackoffActivity.kt)
    * [ViewModel Code](app/src/main/java/me/amitshekhar/learn/kotlin/flow/ui/retryexponentialbackoff/RetryExponentialBackoffModel.kt)

* **Unit Test:** Learn how write unit-test for ViewModel which uses Kotlin Flow.
    * [ViewModelTest Code](app/src/test/java/me/amitshekhar/learn/kotlin/flow/ui/retrofit/single/SingleNetworkCallViewModelTest.kt)

## If this project helps you in anyway, show your love :heart: by putting a :star: on this project :v:

### License

```
   Copyright (C) 2024 Amit Shekhar

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

**Amit Shekhar**\
Co-Founder @ [Outcome School](https://outcomeschool.com)

You can connect with me on:

- [Twitter](https://twitter.com/amitiitbhu)
- [LinkedIn](https://www.linkedin.com/in/amit-shekhar-iitbhu)
- [GitHub](https://github.com/amitshekhariitbhu)
- [Facebook](https://www.facebook.com/amit.shekhar.iitbhu)

[**Read all of our blogs here.**](https://outcomeschool.com/blog)
