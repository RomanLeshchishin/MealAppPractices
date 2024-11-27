package com.example.mealapppractices.presentation.state

import com.example.mealapppractices.presentation.model.MealItemDetails

interface FavoriteMealsState {
  val favoriteMeals: List<MealItemDetails>
}