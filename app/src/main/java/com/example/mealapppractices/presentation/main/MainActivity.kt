package com.example.mealapppractices.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.mealapppractices.presentation.screen.BottomBarScreen
import org.koin.androidx.compose.KoinAndroidContext

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      val navController = rememberNavController()
      KoinAndroidContext {
        BottomBarScreen(
          navController = navController
        )
      }
    }
  }
}