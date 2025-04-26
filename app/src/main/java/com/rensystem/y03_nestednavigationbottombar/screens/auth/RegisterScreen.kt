package com.rensystem.y03_nestednavigationbottombar.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.rensystem.y03_nestednavigationbottombar.R
import com.rensystem.y03_nestednavigationbottombar.navigation.AuthRouteScreen
import com.rensystem.y03_nestednavigationbottombar.navigation.Graph

@Composable
fun RegisterScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var isFormValid by remember { mutableStateOf(false) }

    // Validación de los campos
    val isEmailValid = email.contains("@") && email.contains(".")
    val isPasswordValid = password.length >= 6
    val isPasswordMatch = password == confirmPassword

    // Actualizar el estado del botón de Register
    LaunchedEffect(isEmailValid, isPasswordValid, isPasswordMatch) {
        isFormValid = isEmailValid && isPasswordValid && isPasswordMatch
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Imagen o logo de la aplicación
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .padding(bottom = 16.dp)
        )

        // Título de la pantalla
        Text(
            text = "Register Screen",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Campo de correo electrónico
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            isError = email.isNotEmpty() && !isEmailValid
        )
        if (email.isNotEmpty() && !isEmailValid) {
            Text(
                text = "Por favor, ingresa un correo válido",
                color = MaterialTheme.colorScheme.error
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de contraseña
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            isError = password.isNotEmpty() && !isPasswordValid
        )
        if (password.isNotEmpty() && !isPasswordValid) {
            Text(
                text = "La contraseña debe tener al menos 6 caracteres",
                color = MaterialTheme.colorScheme.error
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de confirmar contraseña
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirm Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            isError = confirmPassword.isNotEmpty() && !isPasswordMatch
        )
        if (confirmPassword.isNotEmpty() && !isPasswordMatch) {
            Text(
                text = "Las contraseñas no coinciden",
                color = MaterialTheme.colorScheme.error
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón de registrar
        Button(
            onClick = {
                navController.navigate(Graph.MainGraph){
                    popUpTo(AuthRouteScreen.SignUp){
                        inclusive = true
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = isFormValid
        ) {
            Text("Registrar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // TextButton para navegar al Login si ya tiene cuenta
        TextButton(
            onClick = {
                navController.navigateUp() // Redirigir a la pantalla de Login
            }
        ) {
            Text("¿Ya tienes una cuenta? Inicia sesión")
        }
    }
}
