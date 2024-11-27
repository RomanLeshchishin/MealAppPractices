package com.example.mealapppractices.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.mealapppractices.presentation.main.MealDetailsViewModel
import org.koin.androidx.compose.koinViewModel

@SuppressLint("SuspiciousIndentation")
@Composable
fun MealItemDetailsScreen(
  areaTitle: String?,
  mealId: String,
  navController: NavController
) {
  val viewModel = koinViewModel<MealDetailsViewModel>()
  viewModel.onMealItemClick(mealId.toInt())
  val state = viewModel.viewState
  var isFavorite = viewModel.getIsFavorite(mealId)
  val icon = if (isFavorite)
    Icons.Default.Favorite
  else
    Icons.Default.FavoriteBorder

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
          Icon(
            imageVector = icon,
            contentDescription = null,
            Modifier
              .padding(start = 250.dp)
              .align(Alignment.CenterVertically)
              .size(40.dp)
              .clickable {
                viewModel.onFavoriteClicked(mealId.toInt())
              }
          )
        }
      }
    )
    { innerPadding ->
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
          .padding(16.dp)
      ) {
        items(state.mealsDetails) { mealDetail ->
          ListItem(
            modifier = Modifier
              .padding(8.dp),
            headlineContent = {
              Column {
                Text(
                  text = mealDetail.title,
                  style = MaterialTheme.typography.titleLarge,
                  modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Image(
                  painter = rememberAsyncImagePainter(mealDetail.imgUrl),
                  contentDescription = null,
                  modifier = Modifier
                    .size(350.dp)
                    .align(Alignment.CenterHorizontally)
                    .clip(shape = RoundedCornerShape(10.dp))
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                  text = "Категория: " + mealDetail.category,
                  style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                  text = "Страна: " + mealDetail.area,
                  style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                  text = "Описание: " + mealDetail.instructions,
                  style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                  text = "Ингридиенты: " + mealDetail.ingredients.map { "${it.ingredient} - ${it.measure}; " }
                    .joinToString(""),
                  style = MaterialTheme.typography.bodyLarge
                )
              }
            }
          )
        }
      }
    }
}