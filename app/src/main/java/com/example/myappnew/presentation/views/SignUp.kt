package com.example.myappnew.presentation.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.AutofillType
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myappnew.presentation.database.model.UserEntity
import com.example.myappnew.presentation.database.viewModel.SignUpViewModel
import com.example.myappnew.ui.theme.MyAppNewTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable

fun SignUpScreen(navController: NavController,signUpViewModel: SignUpViewModel) {
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val snackbarHostState = remember { SnackbarHostState() }

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var dob by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        // Collect any events or show snackbar as needed
        // viewModel.eventFlow.collectLatest { event ->
        //     when (event) {
        //         is UiEvent.ShowSnackbar -> {
        //             snackbarHostState.showSnackbar(
        //                 message = event.message,
        //                 duration = SnackbarDuration.Short
        //             )
        //         }
        //         // Handle other events as needed
        //     }
        // }
    }

    Scaffold(
        topBar = {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    text = "Getting Started",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Create an account to continue with your shopping",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light
                )
            }
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Input fields for Name, Email, Password, Date of Birth, and Address
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(bottom = 12.dp),
                label = { Text("Name") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = null
                    )
                },
                singleLine = true,
            )


            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(bottom = 12.dp),
                label = { Text(text = "Email") },
                leadingIcon = { Icon(imageVector = Icons.Filled.Email, contentDescription = null) },
                singleLine = true,
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(bottom = 12.dp),
                label = { Text("Password") },
                leadingIcon = { Icon(imageVector = Icons.Filled.Close, contentDescription = null) },
                singleLine = true,
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { passwordVisibility = !passwordVisibility }) {

                    }
                },
            )

            OutlinedTextField(
                value = dob,
                onValueChange = { dob = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(bottom = 12.dp),
                label = { Text("Date of Birth") },
                leadingIcon = { Icon(Icons.Filled.DateRange, contentDescription = null) },
                singleLine = true,
            )

            OutlinedTextField(
                value = address,
                onValueChange = { address = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(bottom = 12.dp),
                label = { Text("Address") },
                leadingIcon = { Icon(Icons.Filled.Home, contentDescription = null) },
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(20.dp))
            // Button to submit the form
            Button(
                onClick = {
                    keyboardController?.hide()
                    val user = UserEntity(
                        name = name,
                        email = email,
                        password = password,
                        dob = dob,
                        address = address
                    )

                    // Save the user data to the Room Database
                    signUpViewModel.signUpUser(user)

                    // Handle signup logic
                    // Call the viewModel.signupUser() or navigate to the next screen
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            ) {
                Text("Sign Up")
            }

            // Text to navigate back to the login screen
            TextButton(
                onClick = {
                    // Handle navigation to the login screen
                    // You can use the navController to navigate
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text("Already have an account? ")
                    Text(
                        text = "Log in",
                        modifier = Modifier.clickable {
                            // Handle click on "Log in"
                            navController.navigate("loginscreen")
                        }
                    )
                }
            }


        }
    }

}
//@Preview
//@Composable
//fun SignUpScreenPreview() {
//    MyAppNewTheme {
//        SignUpScreen(navController = na)
//    }
//}