package com.example.mealapppractices.presentation.state

import androidx.compose.runtime.Stable
import com.example.mealapppractices.presentation.model.Category

@Stable
interface CategoryState {
  val categories: List<Category>
  val error: String?
  val loading: Boolean
}