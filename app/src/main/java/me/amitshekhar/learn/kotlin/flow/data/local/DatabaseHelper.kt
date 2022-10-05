package me.amitshekhar.learn.kotlin.flow.data.local

import kotlinx.coroutines.flow.Flow
import me.amitshekhar.learn.kotlin.flow.data.local.entity.User

interface DatabaseHelper {

    fun getUsers(): Flow<List<User>>

    fun insertAll(users: List<User>): Flow<Unit>

}