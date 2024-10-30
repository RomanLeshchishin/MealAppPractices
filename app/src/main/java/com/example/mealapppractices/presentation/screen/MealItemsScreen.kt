@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.mealapppractices.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.mealapppractices.presentation.handlers.MealItemsScreenHandler
import com.example.mealapppractices.presentation.main.MealViewModel
import com.example.mealapppractices.ui.components.FullScreenProgress
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("SuspiciousIndentation")
@Composable
fun MealItemsScreen(
  categoryTitle: String,
  navController: NavHostController
) {
  val handler = MealItemsScreenHandler(navController)
  val viewModel = koinViewModel<MealViewModel>()
  viewModel.onCategoryClick(categoryTitle)
  val state = viewModel.viewState

    Scaffold(modifier = Modifier.fillMaxSize(),
      topBar = {
        Row {
          Button(
            onClick = { navController.popBackStack() },
            Modifier.padding(all = 5.dp)
          ) {
            Text(
              text = "Назад",
              color = Color.Black
            )
          }
          Text(
            text = categoryTitle,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
              .padding(top = 15.dp, start = 15.dp)
          )
        }
      }
    ) { innerPadding ->
      Column {
        state.error?.let {
          Row(modifier = Modifier.padding(top = 50.dp)) {
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
      LazyColumn(
        modifier = Modifier
          .padding(innerPadding)
      ) {
        items(state.meals) { meal ->
          ListItem(
            modifier = Modifier
              .clickable { handler.onToMeals(categoryTitle, meal.id) }
              .padding(8.dp),
            headlineContent = {
              Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Image(
                  painter = rememberAsyncImagePainter(meal.imgUrl),
                  contentDescription = null,
                  modifier = Modifier
                    .size(150.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(meal.title, style = MaterialTheme.typography.titleLarge)
              }
            }
          )
        }
      }
    }
}