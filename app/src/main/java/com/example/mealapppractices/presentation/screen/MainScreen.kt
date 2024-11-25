
package com.example.mealapppractices.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mealapppractices.presentation.handlers.CategoriesScreenHandler
import com.example.mealapppractices.presentation.handlers.MealItemsScreenHandler
import com.example.mealapppractices.presentation.main.MainViewModel
import com.example.mealapppractices.presentation.screen.model.ScreenBar
import com.example.mealapppractices.ui.components.FullScreenProgress
import com.example.mealapppractices.ui.components.ListCategories
import com.example.mealapppractices.ui.components.ListMeals
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(
  navController: NavHostController
) {
  val mealsHandler = MealItemsScreenHandler(navController)
  val categoriesHandler = CategoriesScreenHandler(navController)
  val viewModel = koinViewModel<MainViewModel>()
  val state = viewModel.viewState

    Scaffold(modifier = Modifier.fillMaxSize(),
      topBar = {
        if (state.area == "") {
          CategoriesTopBar()
        }
        else {
          MealsTopBar()
        }
      }
    ) { innerPadding ->
      Column {
        state.error?.let {
          Row(modifier = Modifier.padding(innerPadding)) {
            Icon(
              imageVector = Icons.Default.Refresh,
              contentDescription = null,
              Modifier.clickable { viewModel.onReloadClicked() }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = it)
          }
        }
      }
      if (state.area == "") {
        ListCategories(categoriesHandler, state.categories)
      }
      else {
        ListMeals(mealsHandler, state.mealsByArea, state.area)
      }
    }
  if (state.loading) {
    FullScreenProgress()
  }
}

@Composable
fun CategoriesTopBar() {
  Text(
    text = "Категории блюд",
    style = MaterialTheme.typography.titleLarge,
    modifier = Modifier
      .padding(start = 15.dp)
      .background(Color.White)
      .fillMaxWidth()
  )
}

@Composable
fun MealsTopBar() {
  Text(
    text = ScreenBar.Main.title ?: "Нет названия",
    style = MaterialTheme.typography.titleLarge,
    modifier = Modifier
      .padding(start = 15.dp)
      .background(Color.White)
      .fillMaxWidth()
  )
}