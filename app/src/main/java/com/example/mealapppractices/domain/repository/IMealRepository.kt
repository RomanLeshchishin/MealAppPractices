package com.example.mealapppractices.domain.repository

import com.example.mealapppractices.presentation.model.Area
import com.example.mealapppractices.presentation.model.Category
import com.example.mealapppractices.presentation.model.Ingredient
import com.example.mealapppractices.presentation.model.MealItem
import com.example.mealapppractices.presentation.model.MealItemDetails

interface IMealRepository {
  suspend fun getCategories(): List<Category>

  suspend fun getMealsByCategory(category: String): List<MealItem>

  suspend fun getMealsByArea(area: String): List<MealItem>

  suspend fun getMealsByIngredient(ingredient: String): List<MealItem>

  suspend fun getAreas(): List<Area>

  suspend fun getIngredients(): List<Ingredient>

  suspend fun getMealsDetailsById(id: Int): List<MealItemDetails>
}