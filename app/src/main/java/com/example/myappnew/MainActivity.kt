package com.example.myappnew

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myappnew.presentation.Navigation.NavGraphScreens
import com.example.myappnew.presentation.database.viewModel.SignUpViewModel
import com.example.myappnew.presentation.viewModels.LoginViewModel
import com.example.myappnew.presentation.views.FirstPage
import com.example.myappnew.presentation.views.LoginScreen
import com.example.myappnew.presentation.views.SignUpScreen
import com.example.myappnew.ui.theme.MyAppNewTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("ComposableDestinationInComposeScope")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            // Set up the NavHost
            NavHost(
                navController = navController,
                startDestination = NavGraphScreens.FirstPage.route
            ) {
                // Define composable destinations
                composable(route = NavGraphScreens.FirstPage.route) {
                    FirstPage(
                        onNavigateToLogin = {
                            // Navigate to the login screen when needed
                            navController.navigate(NavGraphScreens.LoginScreen.route)
                        },
                        onNavigateToSignUp = {
                            // Navigate to the sign-up screen when needed
                            navController.navigate(NavGraphScreens.SignUpScreen.route)
                        })
                }

                composable(route = NavGraphScreens.LoginScreen.route) {
                    val loginViewModel = viewModel<LoginViewModel>()

                    LoginScreen(
                        viewModel = loginViewModel,
                        onNavigateBack = {
                            // Navigate back to the previous screen when needed
                            navController.popBackStack()
                        },
                        navController = navController
                    )
                }

                composable(route = NavGraphScreens.SignUpScreen.route) {
                    val signUpViewModel: SignUpViewModel by viewModels()

                    // Content for SignUpScreen goes here
                    // You can create a SignUpScreen composable or any other content for this route
                    SignUpScreen(navController,signUpViewModel)
                }


            }
        }
    }
}
