package com.example.mealapppractices.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.mealapppractices.presentation.main.FavoriteMealsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun FavoriteMealsScreen() {
  val viewModel = koinViewModel<FavoriteMealsViewModel>()
  val state = viewModel.viewState

  LazyColumn(
    modifier = Modifier
      .padding(16.dp)
  ) {
    items(state.favoriteMeals) { mealDetail ->
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
          }
        }
      )
    }
  }
}