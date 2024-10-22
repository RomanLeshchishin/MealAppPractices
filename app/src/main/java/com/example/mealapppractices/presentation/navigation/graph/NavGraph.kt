package com.example.mealapppractices.presentation.navigation.graph

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
      CategoriesScreen { categoryName ->
        navController.navigate("category/$categoryName") {}
      }
    }

    composable("category/{categoryName}") { backStackEntry ->
      val categoryName = backStackEntry.arguments?.getString("categoryName") ?: ""
      MealItemsScreen({ mealItemId ->
        navController.navigate("category/$categoryName/$mealItemId") {} } ,
        categoryTitle = categoryName
      )
    }

    composable("category/{categoryName}/{categoryId}") { backStackEntry ->
      val mealItemId = backStackEntry.arguments?.getString("mealItemId") ?: ""
      MealItemDetailsScreen(mealItemId, navController)
    }

    composable(ScreenBar.Home.route) {
      HomeScreen()
    }

    composable(ScreenBar.Notifications.route) {
      NotificationsScreen()
    }
  }
}