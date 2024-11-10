package com.example.mealapppractices.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mealapppractices.presentation.navigation.NavGraph
import com.example.mealapppractices.ui.components.BottomBar
import com.example.mealapppractices.presentation.screen.model.ScreenBar

@Composable
fun BottomBarScreen(navController: NavHostController) {

  val navBackStackEntry by navController.currentBackStackEntryAsState()
  val currentDestination = navBackStackEntry?.destination

  val screens = listOf(
    ScreenBar.Categories.route,
    ScreenBar.Home.route,
    ScreenBar.Notifications.route
  )

  val showBottomBar = currentDestination?.route in screens

  Scaffold(
    modifier = Modifier
      .fillMaxSize(),
    bottomBar = {
      if (showBottomBar) {
        BottomBar(
          navController = navController,
        )
      }
    }

  ) { paddingValues ->
    Box(
      modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)
    ) {
      NavGraph(navController = navController)
    }
  }
}