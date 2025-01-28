package com.example.focuspanda.CommenSection

import com.example.focuspanda.Model.NavIterm
import com.example.focuspanda.Screens.MainScreen


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.focuspanda.Screens.PomodoroTimerScreen
import com.example.focuspanda.Screens.ToDoListScreen
import com.example.focuspanda.Screens.UserProfileScreen


@Composable
fun BottomNavigationScreen(modifier: Modifier = Modifier) {

    val navItermList = listOf(
        NavIterm("Pomodoro" , Icons.Default.Star),
        NavIterm("To do list" , Icons.Default.Settings),
        NavIterm("Dashboard" , Icons.Default.List),
        NavIterm("Profile" , Icons.Default.Person),

        )
    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    Scaffold (modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                navItermList.forEachIndexed { index, navIterm ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = {
                            Icon(imageVector = navIterm.icon, contentDescription = "Icon")
                        },
                        label = {
                            Text(text = navIterm.label)
                        }
                    )
                }
            }
        }
    ){ innerPadding ->
        contentScreen(modifier = Modifier.padding(innerPadding),selectedIndex)
    }
}
@Composable
fun contentScreen (modifier: Modifier = Modifier,selectedIndex :Int ) {
    when(selectedIndex){
        0->PomodoroTimerScreen()
        1->ToDoListScreen()
        2->MainScreen()
        3-> UserProfileScreen()




    }
}
