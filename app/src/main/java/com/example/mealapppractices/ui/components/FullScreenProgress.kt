package com.example.mealapppractices.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FullScreenProgress() {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() },
        onClick = { }
      ),
    contentAlignment = Alignment.Center
  ) {
    CircularProgressIndicator(
      modifier = Modifier.width(40.dp),
      color = MaterialTheme.colorScheme.primary
    )
  }
}