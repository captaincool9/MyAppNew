package com.example.myappnew.presentation.database.di

import android.content.Context
import androidx.room.Room
import com.example.myappnew.presentation.database.model.AppDatabase
import com.example.myappnew.presentation.database.model.UserDao
import com.example.myappnew.presentation.database.repo.UserRepository
import com.example.myappnew.presentation.database.viewModel.SignUpViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)

object AppModule {

    @Provides
    fun provideUserDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.userDao()
    }

    @Provides
    fun provideUserRepository(userDao: UserDao): UserRepository {
        return UserRepository(userDao)
    }

    @Provides
    @ViewModelScoped
    fun provideSignUpViewModel(userRepository: UserRepository): SignUpViewModel {
        return SignUpViewModel(userRepository)
    }

    @Provides
    @ViewModelScoped
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }
}