package com.example.mealapppractices.presentation.handlers

import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController

class ProfileScreenHandler(
  val navController: NavHostController
) {
  fun onToEditProfile() {
    navController.navigate("editProfile")
    if (navController.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED) {
      navController.popBackStack()
    }
  }
}