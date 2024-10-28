package com.example.mealapppractices.domain.repository

import com.example.mealapppractices.presentation.model.Category
import com.example.mealapppractices.presentation.model.MealItem
import com.example.mealapppractices.presentation.model.MealItemDetails

interface IMealRepository {
  suspend fun getCategories(): List<Category>

  suspend fun getMeals(category: String): List<MealItem>

  suspend fun getMealDetails(meal: String): List<MealItemDetails>
}