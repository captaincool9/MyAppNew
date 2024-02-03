package com.example.myappnew.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    // MutableStateFlows to represent the state of different fields
    private val _usernameState = MutableStateFlow("")
    private val _passwordState = MutableStateFlow("")
    private val _rememberMeState = MutableStateFlow(false)

    // Expose StateFlows as immutable StateFlows to the UI
    val usernameState: StateFlow<String> = _usernameState
    val passwordState: StateFlow<String> = _passwordState
    val rememberMeState: StateFlow<Boolean> = _rememberMeState

    // Event Flow to communicate UI events to the UI layer
    private val _eventFlow = MutableStateFlow<UiEvent?>(null)
    val eventFlow: StateFlow<UiEvent?> = _eventFlow

    // ViewModel actions

    fun setUsername(username: String) {
        _usernameState.value = username
    }

    fun setPassword(password: String) {
        _passwordState.value = password
    }

    fun setRememberMe(rememberMe: Boolean) {
        _rememberMeState.value = rememberMe
    }

    fun loginUser() {
        // Perform login logic here
        val username = _usernameState.value
        val password = _passwordState.value

        // Simulate a network request or authentication process
        viewModelScope.launch {
            // You can replace this with your actual login logic
            // For example, calling a repository method or making a network request
            if (isValidCredentials(username, password)) {
                _eventFlow.value = UiEvent.NavigateToHomeScreen
            } else {
                _eventFlow.value = UiEvent.ShowSnackbar("Invalid credentials")
            }
        }
    }

    // Replace this with your actual validation logic
    private fun isValidCredentials(username: String, password: String): Boolean {
        // Add your validation logic here
        return username.isNotEmpty() && password.isNotEmpty()
    }
}

sealed class UiEvent {
    data class ShowSnackbar(val message: String) : UiEvent()
    object NavigateToHomeScreen : UiEvent()
}
