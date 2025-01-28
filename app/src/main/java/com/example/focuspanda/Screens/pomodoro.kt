package com.example.focuspanda.Screens



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PomodoroTimerScreen() {
    var minutes by remember { mutableStateOf(20) }
    var seconds by remember { mutableStateOf(0) }

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
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TimerDisplay(minutes, seconds)
                ControlButtons(
                    onTakeBreak = { /* Take a break action */ },
                    onCancelSession = { /* Cancel session action */ },
                    onBack = { /* Navigate back */ }
                )
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
                TimerDisplay(minutes, seconds)
                Spacer(modifier = Modifier.height(24.dp))
                ControlButtons(
                    onTakeBreak = { /* Take a break action */ },
                    onCancelSession = { /* Cancel session action */ },
                    onBack = { /* Navigate back */ }
                )
            }
        }

        // Floating Action Button
        FloatingActionButton(
            onClick = { /* Handle edit session */ },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            containerColor = Color(0xFF4CAF50)
        ) {
            Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit Session")
        }
    }
}

@Composable
fun TimerDisplay(minutes: Int, seconds: Int) {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Pomodoro Timer",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = "1 hr session",
            fontSize = 16.sp,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            TimerBox(value = minutes)
            Text(text = ":", fontSize = 40.sp, fontWeight = FontWeight.Bold)
            TimerBox(value = seconds)
        }
    }
}

@Composable
fun TimerBox(value: Int) {
    Box(
        modifier = Modifier
            .size(80.dp)
            .background(Color(0xFFEDE7F6), shape = RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = value.toString().padStart(2, '0'),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}

@Composable
fun ControlButtons(
    onTakeBreak: () -> Unit,
    onCancelSession: () -> Unit,
    onBack: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = onTakeBreak,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB2FF59))
            ) {
                Text("Take Break")
            }
            Button(
                onClick = onCancelSession,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB39DDB))
            ) {
                Text("Cancel Session")
            }
        }
        Button(
            onClick = onBack,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
        ) {
            Text("Back")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PomodoroTimerScreenPreview() {
    PomodoroTimerScreen()
}

