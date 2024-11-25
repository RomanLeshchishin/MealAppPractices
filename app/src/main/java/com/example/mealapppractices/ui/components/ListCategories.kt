package com.example.mealapppractices.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.mealapppractices.presentation.handlers.CategoriesScreenHandler
import com.example.mealapppractices.presentation.model.Category

@Composable
fun ListCategories(handler: CategoriesScreenHandler, listItems: List<Category>) {
  LazyColumn(
    modifier = Modifier
      .padding(10.dp)
  ) {
    items(listItems) { item ->
      ListItem(
        modifier = Modifier
          .clickable { handler.onToCategories(item.title) }
          .padding(8.dp),
        headlineContent = {
          Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Image(
              painter = rememberAsyncImagePainter(item.imgUrl),
              contentDescription = null,
              modifier = Modifier
                .size(170.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
              Text(item.title, style = MaterialTheme.typography.titleLarge)
              Text(
                text = SubText(item.description),
                style = MaterialTheme.typography.bodyLarge
              )
            }
          }
        }
      )
    }
  }
}

fun SubText(text: String): String {
  if (text.length > 90)
  {
    return text.substring(0, 90) + "..."
  }
  else
  {
    return text.substring(0, text.length)
  }
}
