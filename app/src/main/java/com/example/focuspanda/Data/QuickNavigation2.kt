package com.example.focuspanda.Data

import com.example.focuspanda.Model.QuickNavigate1
import com.example.focuspanda.R

class QuickNavigationIterm {
    fun loadQuickNavigationIterm ():List<QuickNavigate1>{
        return listOf<QuickNavigate1>(
            QuickNavigate1(
                R.drawable.pomodoro,
                R.string.item_Pomodoro,
                R.string.Pomo_time,
            ),
            QuickNavigate1(
                R.drawable.,
                R.string.item_Flashcard,
                R.string.Knowledge,
            ),
            QuickNavigate1(
                R.drawable.duli,
                R.string.item_Notes,
                R.string.Note,
            ),
            QuickNavigate1(
                R.drawable.flash,
                R.string.item_Flashcard,
                R.string.Knowledge,
            )
        )
    }
}