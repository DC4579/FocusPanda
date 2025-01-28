package com.example.focuspanda.Screens



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.focuspanda.R

@Composable
fun UserProfileScreen() {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD0F5D8)) // Light green background
    ) {
        val isLandscape = maxWidth > maxHeight

        if (isLandscape) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ProfileImageSection()
                ProfileDetailsSection()
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ProfileImageSection()
                Spacer(modifier = Modifier.height(16.dp))
                ProfileDetailsSection()
            }
        }

        FloatingButtonSection(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun ProfileImageSection() {
    Image(
        painter = painterResource(id = R.drawable.panda_image), // Replace with actual image
        contentDescription = "Profile Picture",
        modifier = Modifier
            .size(120.dp)
            .background(Color.LightGray, CircleShape),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun ProfileDetailsSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFB8F0C9)), // Green card color
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ProfileDetailRow(label = "User name", value = "Gojo Satoru")
            ProfileDetailRow(label = "Email", value = "jjk@gmail.com")
            ProfileDetailRow(label = "Password", value = "*********")
            ProfileDetailRow(label = "Phone number", value = "0712345676")
        }
    }
}

@Composable
fun ProfileDetailRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text(text = value, fontSize = 16.sp)
    }
}

@Composable
fun FloatingButtonSection(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            onClick = { /* Save Action */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)) // Green
        ) {
            Text(text = "Save", color = Color.White)
        }

        Button(
            onClick = { /* Edit Action */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDCCB00)) // Yellow
        ) {
            Text(text = "Edit", color = Color.White)
        }

        Button(
            onClick = { /* Delete Action */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text(text = "Delete", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserProfileScreenPreview() {
    UserProfileScreen()
}
