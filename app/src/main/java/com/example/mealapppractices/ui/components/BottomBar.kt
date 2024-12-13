package com.example.mealapppractices.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mealapppractices.presentation.extension.AddItem
import com.example.mealapppractices.presentation.main.MainViewModel
import com.example.mealapppractices.presentation.screen.model.ScreenBar
import org.koin.androidx.compose.koinViewModel

@Composable
fun BottomBar(
  navController: NavHostController,
) {
  val items = listOf(
    ScreenBar.Main,
    ScreenBar.Favorite,
    ScreenBar.Settings,
    ScreenBar.Profile
  )

  val navBackStackEntry by navController.currentBackStackEntryAsState()
  val destination = navBackStackEntry?.destination
  val viewModel = koinViewModel<MainViewModel>()
  val viewState = viewModel.viewState

  NavigationBar {
    items.forEach { screen ->
      AddItem(
        screen = screen,
        destination = destination,
        navController = navController,
        isBadge = viewState.isShowBadge
      )
    }
  }
}

@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
  BottomBar(
    navController = rememberNavController()
  )
}