package com.example.mealapppractices.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mealapppractices.presentation.screen.FavoriteMealsScreen
import com.example.mealapppractices.presentation.screen.MealItemDetailsScreen
import com.example.mealapppractices.presentation.screen.MainScreen
import com.example.mealapppractices.presentation.screen.MealItemsScreen
import com.example.mealapppractices.presentation.screen.ProfileScreen
import com.example.mealapppractices.presentation.screen.SettingsScreen
import com.example.mealapppractices.presentation.screen.model.ScreenBar

@Composable
fun NavGraph(
  navController: NavHostController
) {

  NavHost(navController = navController, startDestination = ScreenBar.Main.route) {
    composable(ScreenBar.Main.route) {
      MainScreen(navController)
    }

    composable("${ScreenBar.Main.route}/{categoryName}") { backStackEntry ->
      val categoryName = backStackEntry.arguments?.getString("categoryName") ?: ""
      MealItemsScreen(categoryName, navController)
    }

    composable("${ScreenBar.Main.route}/{categoryName}/{mealId}") { backStackEntry ->
      val mealId = backStackEntry.arguments?.getString("mealId") ?: ""
      MealItemDetailsScreen(null, mealId, navController)
    }

    composable("${ScreenBar.Main.route}/{areaName}/{mealId}") { backStackEntry ->
      val areaName = backStackEntry.arguments?.getString("areaName") ?: ""
      val mealId = backStackEntry.arguments?.getString("mealId") ?: ""
      MealItemDetailsScreen(areaName, mealId, navController)
    }

    composable(ScreenBar.Profile.route) {
      ProfileScreen()
    }

    composable(ScreenBar.Favorite.route) {
      FavoriteMealsScreen()
    }

    composable(ScreenBar.Settings.route) {
      SettingsScreen(navController)
    }
  }
}