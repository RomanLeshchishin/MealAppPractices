package com.example.mealapppractices.presentation.state

import androidx.compose.runtime.Stable
import com.example.mealapppractices.presentation.model.MealItem

@Stable
interface MealState {
  val meals: List<MealItem>
  val category: String
  val error: String?
  val loading: Boolean
}