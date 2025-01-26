package com.example.focuspanda.Data

import com.example.focuspanda.Model.QuickNavigate1
import com.example.focuspanda.R

class QuickNavigationIterm {
    fun loadQuickNavigationIterm ():List<QuickNavigate1>{
        return listOf<QuickNavigate1>(
            QuickNavigate1(
                R.drawable.duli,
                R.string.item_latte,
                R.string.price_latte,
            ),
            QuickNavigate1(
                R.drawable.duli,
                R.string.item_espresso,
                R.string.price_latte,
            ),
            QuickNavigate1(
                R.drawable.duli,
                R.string.item_latte,
                R.string.price_latte,
            ),
            QuickNavigate1(
                R.drawable.duli,
                R.string.item_latte,
                R.string.price_latte,
            )
        )
    }
}