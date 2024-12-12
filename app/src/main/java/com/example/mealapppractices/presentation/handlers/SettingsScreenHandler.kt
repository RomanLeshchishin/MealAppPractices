package com.example.mealapppractices.presentation.handlers

import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController
import com.example.mealapppractices.presentation.screen.model.ScreenBar

class SettingsScreenHandler(
  val navController: NavHostController
) {
  fun onToSave()
  {
    navController.navigate(ScreenBar.Main.route)
    if (navController.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED) {
      navController.popBackStack()
    }
  }
}