package com.example.mealapppractices.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mealapppractices.presentation.screen.CategoriesScreen
import com.example.mealapppractices.presentation.screen.HomeScreen
import com.example.mealapppractices.presentation.screen.MealItemDetailsScreen
import com.example.mealapppractices.presentation.screen.MealItemsScreen
import com.example.mealapppractices.presentation.screen.NotificationsScreen
import com.example.mealapppractices.presentation.screen.model.ScreenBar

@Composable
fun NavGraph(
  navController: NavHostController
) {

  NavHost(navController = navController, startDestination = ScreenBar.Categories.route) {
    composable(route = ScreenBar.Categories.route) {
      CategoriesScreen(navController)
    }

    composable("categories/{categoryName}") { backStackEntry ->
      val categoryName = backStackEntry.arguments?.getString("categoryName") ?: ""
      MealItemsScreen(categoryName, navController)
    }

    composable("categories/{categoryName}/{mealId}") { backStackEntry ->
      val mealId = backStackEntry.arguments?.getString("mealId") ?: ""
      MealItemDetailsScreen(mealId, navController)
    }

    composable(ScreenBar.Home.route) {
      HomeScreen()
    }

    composable(ScreenBar.Notifications.route) {
      NotificationsScreen()
    }
  }
}