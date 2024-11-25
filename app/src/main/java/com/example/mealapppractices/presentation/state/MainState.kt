package com.example.mealapppractices.presentation.state

import androidx.compose.runtime.Stable
import com.example.mealapppractices.presentation.model.Category
import com.example.mealapppractices.presentation.model.MealItem

@Stable
interface MainState {
  val categories: List<Category>
  val mealsByArea: List<MealItem>
  val area: String
  val error: String?
  val loading: Boolean
}