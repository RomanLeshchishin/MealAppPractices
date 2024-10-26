package com.example.mealapppractices.presentation.navigation.ui

import androidx.compose.runtime.Composable
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mealapppractices.presentation.extension.AddItem
import com.example.mealapppractices.presentation.screen.model.ScreenBar

@Composable
fun BottomBar(
  navController: NavHostController,
) {
  val items = listOf(
    ScreenBar.Home,
    ScreenBar.Categories,
    ScreenBar.Notifications
  )

  val navBackStackEntry by navController.currentBackStackEntryAsState()
  val destination = navBackStackEntry?.destination
  NavigationBar {
    items.forEach { screen ->
      AddItem(
        screen = screen,
        destination = destination,
        navController = navController,
      )
    }
  }
}

@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
  BottomBar(
    navController = rememberNavController()
  )
}