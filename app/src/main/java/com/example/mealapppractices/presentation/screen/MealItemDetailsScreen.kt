@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.mealapppractices.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.mealapppractices.presentation.main.MainViewModel

@Composable
fun MealItemDetailsScreen(
  mealItemId: String,
  navController: NavController,
  viewModel: MainViewModel = viewModel()
) {
  val mealItemDetails = viewModel.mealItemDetails.find { it.id == mealItemId }

  if (mealItemDetails != null) {
    Scaffold(modifier = Modifier.fillMaxSize(),
      topBar = {
        TopAppBar(
          title = {
            CenterAlignedTopAppBar(title = {
              Text(
                text = mealItemDetails.title
              )
            })
          }
        )
      }
    ) { innerPadding ->
      Column(
        modifier = Modifier
          .padding(innerPadding)
          .padding(16.dp)
      ) {
        Text(
          text = mealItemDetails.title,
        )
        Spacer(modifier = Modifier.height(24.dp))
        Image(
          painter = rememberAsyncImagePainter(mealItemDetails.imgUrl),
          contentDescription = null,
          modifier = Modifier
            .size(250.dp)
            .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(text ="Категория: " + mealItemDetails.category, style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Страна: " + mealItemDetails.area, style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Описание: " + mealItemDetails.instructions, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
          text = "Ингридиенты: " + mealItemDetails.ingredients.map { "${it.ingredient} - ${it.measure};" },
          style = MaterialTheme.typography.bodyLarge
        )
      }
    }
  }

  else {
    Text(text = "The dish was not found", style = MaterialTheme.typography.bodyMedium)
  }

  Button(
    onClick = { navController.popBackStack() }
  ) {
    Text(
      text = "Назад",
      color = Color.Black
    )
  }
}