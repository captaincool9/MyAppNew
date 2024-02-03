package com.example.myappnew.presentation.database.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myappnew.presentation.database.model.UserEntity
import com.example.myappnew.presentation.database.repo.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    fun signUpUser(user: UserEntity) {
        viewModelScope.launch {
            userRepository.insert(user)
        }
    }
}