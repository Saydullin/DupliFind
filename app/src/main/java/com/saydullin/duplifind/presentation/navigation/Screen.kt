package com.saydullin.duplifind.presentation.navigation

import com.saydullin.duplifind.R

sealed class Screen(
    val route: String,
    val title: String,
    val icon: Int,
    val activeIcon: Int
) {
    object Home : Screen(
        route = "home",
        title = "Home",
        icon = R.drawable.logo,
        activeIcon = R.drawable.logo
    )
    object GameScene : Screen(
        route = "gameScene",
        title = "Game Scene",
        icon = R.drawable.logo,
        activeIcon = R.drawable.logo
    )
    object WinScene : Screen(
        route = "winScene",
        title = "Win Scene",
        icon = R.drawable.logo,
        activeIcon = R.drawable.logo
    )
}