package com.example.focuspanda.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.focuspanda.R
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll


@Composable
fun SignUpScreen(onGoBack: () -> Unit) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFFD6F5D6), Color(0xFFA1D6A1))
                )
            )
    ) {
        val isLandscape = maxWidth > maxHeight

        // Background Image
        Image(
            painter = painterResource(id = R.drawable.panda_image),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            alignment = Alignment.Center
        )

        // Semi-transparent overlay
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x88000000)) // Semi-transparent overlay
        )

        if (isLandscape) {
            // Landscape Layout
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Title Section
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Focus Panda",
                        style = MaterialTheme.typography.headlineLarge.copy(
                            fontSize = 30.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    Text(
                        text = "Sign Up",
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontSize = 24.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }

                // Form Section with Scroll
                Column(
                    modifier = Modifier
                        .weight(2f)
                        .fillMaxHeight()
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    SignUpForm(onGoBack)
                }
            }
        } else {
            // Portrait Layout
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Focus Panda",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontSize = 30.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = "Sign Up",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontSize = 24.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Form Section
                SignUpForm(onGoBack)
            }
        }
    }
}

@Composable
fun SignUpForm(onGoBack: () -> Unit) {
    val username = remember { mutableStateOf(TextFieldValue()) }
    val email = remember { mutableStateOf(TextFieldValue()) }
    val password = remember { mutableStateOf(TextFieldValue()) }
    val confirmPassword = remember { mutableStateOf(TextFieldValue()) }

    val textFieldModifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(16.dp))
        .background(Color.White)
        .padding(8.dp)

    OutlinedTextField(
        value = username.value,
        onValueChange = { username.value = it },
        placeholder = { Text("Enter User name") },
        modifier = textFieldModifier
    )

    Spacer(modifier = Modifier.height(8.dp))

    OutlinedTextField(
        value = email.value,
        onValueChange = { email.value = it },
        placeholder = { Text("Enter Email") },
        modifier = textFieldModifier
    )

    Spacer(modifier = Modifier.height(8.dp))

    OutlinedTextField(
        value = password.value,
        onValueChange = { password.value = it },
        placeholder = { Text("Password") },
        visualTransformation = PasswordVisualTransformation(),
        modifier = textFieldModifier
    )

    Spacer(modifier = Modifier.height(8.dp))

    OutlinedTextField(
        value = confirmPassword.value,
        onValueChange = { confirmPassword.value = it },
        placeholder = { Text("Retype Password") },
        visualTransformation = PasswordVisualTransformation(),
        modifier = textFieldModifier
    )

    Spacer(modifier = Modifier.height(16.dp))

    // Buttons
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            onClick = { /* Handle Sign-Up Logic */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp)
        ) {
            Text(text = "Create Account", color = Color.White, textAlign = TextAlign.Center)
        }
        Button(
            onClick = onGoBack,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp)
        ) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Go Back", tint = Color.White)
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "Go Back", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen(onGoBack = {})
}



