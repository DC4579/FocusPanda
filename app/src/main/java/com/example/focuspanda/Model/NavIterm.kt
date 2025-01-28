package com.example.focuspanda.Model

import androidx.compose.ui.graphics.vector.ImageVector

data class NavIterm(
    val label : String,
    val icon : ImageVector,
)
// Task model for holding data about each task


data class Task(
    val title: String,
    val isCompleted: Boolean = false
)
data class Flashcard(
    var front: String,
    var back: String
)

