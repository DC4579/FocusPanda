package com.example.focuspanda.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.font.FontWeight
import com.example.focuspanda.Model.Task



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoListScreen() {
    var tasks by remember {
        mutableStateOf(
            listOf(
                Task("Chemistry 3hr study"),
                Task("Chemistry Tute Work"),
                Task("Chemistry Homework"),
                Task("Biology Paper", true),
                Task("Physics Past Questions")
            )
        )
    }

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        val isLandscape = maxWidth > maxHeight

        if (isLandscape) {
            // Landscape Layout
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TaskList(tasks, onDelete = { task -> tasks = tasks.filter { it != task } })
                BackAndEditButtons()
            }
        } else {
            // Portrait Layout
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                TaskList(tasks, onDelete = { task -> tasks = tasks.filter { it != task } })
                Spacer(modifier = Modifier.height(24.dp))
                BackAndEditButtons()
            }
        }
    }
}

@Composable
fun TaskList(tasks: List<Task>, onDelete: (Task) -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "To Do List",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        tasks.forEach { task ->
            TaskRow(task = task, onDelete = { onDelete(task) })
        }
    }
}

@Composable
fun TaskRow(task: Task, onDelete: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFEDE7F6), RoundedCornerShape(8.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = task.title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black,
            modifier = Modifier.weight(1f)
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = task.isCompleted,
                onCheckedChange = null // Handle checkbox state here if needed
            )
            Spacer(modifier = Modifier.width(8.dp))
            IconButton(onClick = onDelete) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete Task",
                    tint = Color.Red
                )
            }
        }
    }
}

@Composable
fun BackAndEditButtons() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Back Button at its original position (bottom-left)
        Button(
            onClick = { /* Handle back action */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
            modifier = Modifier
                .align(Alignment.BottomStart) // Align to bottom-left
                .padding(16.dp)
        ) {
            Text("Back")
        }

        // FAB in the bottom-right corner
        FloatingActionButton(
            onClick = { /* Handle add/edit task action */ },
            containerColor = Color(0xFF4CAF50),
            modifier = Modifier
                .align(Alignment.BottomEnd) // Align to bottom-right
                .padding(16.dp)
        ) {
            Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit Task")
        }
    }
}





@Preview(showBackground = true)
@Composable
fun ToDoListScreenPreview() {
    ToDoListScreen()
}
