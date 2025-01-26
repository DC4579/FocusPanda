package com.example.focuspanda.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.focuspanda.CommenSection.BottomNavigationScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoListScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("To do List") },
                actions = {
                    Button(
                        onClick = { /* Handle log out */ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF4CAF50), // Green color
                            contentColor = Color.White
                        )
                    ) {
                        Text("Log Out")
                    }
                },
            )


        },
        bottomBar = {
            BottomNavigationScreen() // Add your navigation bar here
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Handle add new to-do */ },
                containerColor = Color(0xFF4CAF50)
            ) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "Add Task")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "To do List",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(16.dp))

            // To-do items
            val tasks = listOf(
                "Chemistry 3hr study",
                "Chemistry Tute Work",
                "Chemistry Homework",
                "Biology Paper",
                "Physics Past Questions"
            )

            tasks.forEachIndexed { index, task ->
                TaskRow(taskName = task, isCompleted = index == 3) // Set Biology Paper as completed
                Spacer(modifier = Modifier.height(8.dp))
            }

            Spacer(modifier = Modifier.weight(1f)) // Push content up
            Button(onClick = { /* Handle Back navigation */ }) {
                Text("Back")
            }
        }
    }
}

@Composable
fun TaskRow(taskName: String, isCompleted: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFFF5F5F5)) // Light gray
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = taskName,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodyLarge
        )
        Checkbox(
            checked = isCompleted,
            onCheckedChange = { /* Handle checkbox state change */ }
        )
        IconButton(
            onClick = { /* Handle delete task */ }
        ) {
            Icon(Icons.Default.Delete, contentDescription = "Delete Task")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ToDoListScreenPreview() {
    ToDoListScreen()
}
