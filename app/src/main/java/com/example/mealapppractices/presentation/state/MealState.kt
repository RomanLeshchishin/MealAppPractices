package com.example.mealapppractices.presentation.state

import com.example.mealapppractices.presentation.model.MealItem

interface MealState {
  val meals: List<MealItem>
  val category: String
  val error: String?
  val loading: Boolean
}