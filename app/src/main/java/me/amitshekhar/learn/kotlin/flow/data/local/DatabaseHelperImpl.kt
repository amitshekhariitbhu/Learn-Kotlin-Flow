package me.amitshekhar.learn.kotlin.flow.data.local

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import me.amitshekhar.learn.kotlin.flow.data.local.entity.User

class DatabaseHelperImpl(private val appDatabase: AppDatabase) : DatabaseHelper {

    override fun getUsers(): Flow<List<User>> = flow {
        emit(appDatabase.userDao().getAll())
    }

    override fun insertAll(users: List<User>): Flow<Unit> = flow {
        appDatabase.userDao().insertAll(users)
        emit(Unit)
    }

}