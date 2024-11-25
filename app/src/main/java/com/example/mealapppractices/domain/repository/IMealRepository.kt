package com.example.mealapppractices.domain.repository

import com.example.mealapppractices.presentation.model.Category
import com.example.mealapppractices.presentation.model.MealItem
import com.example.mealapppractices.presentation.model.MealItemDetails

interface IMealRepository {
  suspend fun getCategories(): List<Category>

  suspend fun getMealsByCategory(category: String): List<MealItem>

  suspend fun getMealsByArea(area: String): List<MealItem>

  suspend fun getMealsByIngredient(ingredient: String): List<MealItem>

  suspend fun getAreas(): List<String>

  suspend fun getIngredients(): List<String>

  suspend fun getMealsDetailsById(id: Int): List<MealItemDetails>
}