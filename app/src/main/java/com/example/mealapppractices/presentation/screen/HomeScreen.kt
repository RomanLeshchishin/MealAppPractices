package com.example.mealapppractices.presentation.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {
  Text(text = "Home Screen", modifier = Modifier.padding(16.dp))
  //фильтрация по стране или по ингридиенту + выбор сортировки: по стране или по ингридиенту + "сохранить"
  //красный или оранжевый индикатор для настроек как в уведомлениях при недефолтных настройках
}