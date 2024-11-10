@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.mealapppractices.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.mealapppractices.presentation.handlers.CategoriesScreenHandler
import com.example.mealapppractices.presentation.main.CategoryViewModel
import com.example.mealapppractices.presentation.screen.model.ScreenBar
import com.example.mealapppractices.ui.components.FullScreenProgress
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriesScreen(navController: NavHostController) {
  val handler = CategoriesScreenHandler(navController)
  val viewModel = koinViewModel<CategoryViewModel>()
  val state = viewModel.viewState

  Scaffold(modifier = Modifier.fillMaxSize(),
    topBar = {
      Text(
        text = ScreenBar.Categories.title ?: "Нет названия",
        style = MaterialTheme.typography.titleLarge,
        modifier = Modifier
          .padding(start = 10.dp)
      )
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
      items(state.categories) { category ->
        ListItem(
          modifier = Modifier
            .clickable { handler.onToCategories(category.title) }
            .padding(8.dp),
          headlineContent = {
            Row(
              modifier = Modifier.fillMaxWidth(),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Image(
                painter = rememberAsyncImagePainter(category.imgUrl),
                contentDescription = null,
                modifier = Modifier
                  .size(170.dp)
              )
              Spacer(modifier = Modifier.width(8.dp))
              Column {
                Text(category.title, style = MaterialTheme.typography.titleLarge)
                Text(
                  text = subText(category.description),
                  style = MaterialTheme.typography.bodyLarge
                )
              }
            }
          }
        )
      }
    }
  }

  if (state.loading) {
    FullScreenProgress()
  }
}

fun subText(text: String): String {
  if (text.length > 90)
  {
    return text.substring(0, 90) + "..."
  }
  else
  {
    return text.substring(0, text.length)
  }
}
