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

@Composable
fun MealItemsScreen(onMealItemClick: (String) -> Unit, categoryTitle: String) {
  val viewModel: MainViewModel = viewModel()
  val mealItems = viewModel.mealItems.find { categoryTitle.lowercase() in it[0].title }

  if (mealItems != null) {
    Scaffold(modifier = Modifier.fillMaxSize(),
      topBar = {
        TopAppBar(
          title = {
            CenterAlignedTopAppBar(title = {
              Text(
                text = categoryTitle
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
        items(mealItems) { mealItem ->
          ListItem(
            modifier = Modifier
              .clickable { onMealItemClick(mealItem.id) }
              .padding(8.dp),
            headlineContent = {
              Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Image(
                  painter = rememberAsyncImagePainter(mealItem.imgUrl),
                  contentDescription = null,
                  modifier = Modifier
                    .size(170.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(mealItem.title, style = MaterialTheme.typography.titleLarge)
              }
            }
          )
        }
      }
    }
  }

  else {
    Text(text = "The dishes were not found", style = MaterialTheme.typography.bodyMedium)
  }
}