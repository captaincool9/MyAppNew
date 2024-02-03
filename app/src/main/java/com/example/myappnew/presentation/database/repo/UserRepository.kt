package com.example.myappnew.presentation.database.repo


import com.example.myappnew.presentation.database.model.UserDao
import com.example.myappnew.presentation.database.model.UserEntity
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDao) {

    val allUsers: Flow<List<UserEntity>> = userDao.getAllUsers()

    suspend fun insert(user: UserEntity) {
        userDao.insertUser(user)
    }
}