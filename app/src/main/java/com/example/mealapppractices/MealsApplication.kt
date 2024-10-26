package com.example.mealapppractices

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.mealapppractices.presentation.screen.BottomBarScreen

class MealsApplication : Application() {
  @Composable
  fun MealsNavHost(){
    val navController = rememberNavController()
    BottomBarScreen(
      navController = navController
    )
  }
}