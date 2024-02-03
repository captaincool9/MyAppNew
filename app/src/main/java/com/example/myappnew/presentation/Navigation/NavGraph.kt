package com.example.myappnew.presentation.Navigation

// NavGraph.kt
sealed class NavGraphScreens(val route: String) {
    object FirstPage : NavGraphScreens("firstPage")
    object LoginScreen : NavGraphScreens("loginScreen")
    object SignUpScreen:NavGraphScreens("signupscreen")
}
