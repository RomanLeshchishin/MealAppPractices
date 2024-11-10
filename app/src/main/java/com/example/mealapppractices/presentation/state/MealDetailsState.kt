package com.example.mealapppractices.presentation.state

import androidx.compose.runtime.Stable
import com.example.mealapppractices.presentation.model.MealItemDetails

@Stable
interface MealDetailsState {
  val mealsDetails: List<MealItemDetails>
  val mealId: Int
  val error: String?
  val loading: Boolean
}