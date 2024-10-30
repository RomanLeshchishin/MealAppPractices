package com.example.mealapppractices.presentation.handlers

import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController
import com.example.mealapppractices.presentation.screen.model.ScreenBar

class CategoriesScreenHandler(
  val navController: NavHostController
) {
  fun onToCategories(category: String) {
    navController.navigate(ScreenBar.Categories.route + "/$category")
    if (navController.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED) {
      navController.popBackStack()
    }
  }
}