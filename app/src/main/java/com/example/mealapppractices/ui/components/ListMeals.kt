package com.example.mealapppractices.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.example.mealapppractices.presentation.handlers.MealItemsScreenHandler
import com.example.mealapppractices.presentation.model.MealItem

@Composable
fun ListMeals(handler: MealItemsScreenHandler, listItems: List<MealItem>, area: String) {
  LazyColumn(
    modifier = Modifier
      .padding(10.dp)
  ) {
    items(listItems) { item ->
      ListItem(
        modifier = Modifier
          .clickable {
            if (area != "") {
              handler.onToMeals(area, item.id)
            }
          }
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
                .size(150.dp)
                .clip(shape = RoundedCornerShape(10.dp))
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(item.title, style = MaterialTheme.typography.titleLarge)
          }
        }
      )
    }
  }
}