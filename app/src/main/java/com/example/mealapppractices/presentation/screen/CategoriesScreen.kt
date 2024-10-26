@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.mealapppractices.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.mealapppractices.presentation.main.MainViewModel
import com.example.mealapppractices.presentation.screen.model.ScreenBar

@Composable
fun CategoriesScreen(onCategoryClick: (String) -> Unit) {
  val viewModel: MainViewModel = viewModel()

  Scaffold(modifier = Modifier.fillMaxSize(),
    topBar = {
      TopAppBar(
        title = {
          CenterAlignedTopAppBar(title = {
            Text(
              text = ScreenBar.Categories.title ?: "Нет названия"
            )
          })
        }
      )
    }
  ) { innerPadding ->
    LazyColumn(
      modifier = Modifier
        .padding(innerPadding)
    ) {
      items(viewModel.categories) { category ->
        ListItem(
          modifier = Modifier
            .clickable { onCategoryClick(category.title) }
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
                Text(category.description, style = MaterialTheme.typography.bodyLarge)
              }
            }
          }
        )
      }
    }
  }
}