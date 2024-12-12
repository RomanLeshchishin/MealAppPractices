package com.example.mealapppractices.presentation.handlers

import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController
import com.example.mealapppractices.presentation.screen.model.ScreenBar

class MealItemsScreenHandler(
  val navController: NavHostController
) {
  fun onToMeals(area: String, id: String)
  {
    navController.navigate(ScreenBar.Main.route + "/$area" + "/$id")
    if (navController.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED) {
      navController.popBackStack()
    }
  }

  fun onToCategoryMeals(category: String, id: String)
  {
    navController.navigate(ScreenBar.Main.route + "/$category" + "/$id")
    if (navController.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED) {
      navController.popBackStack()
    }
  }
}