package com.example.mealapppractices.data.repository

import com.example.mealapppractices.data.api.MealApi
import com.example.mealapppractices.data.mapper.MealsMapper
import com.example.mealapppractices.domain.repository.IMealRepository
import com.example.mealapppractices.presentation.model.Category
import com.example.mealapppractices.presentation.model.MealItem
import com.example.mealapppractices.presentation.model.MealItemDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MealRepository(
  private val api: MealApi,
  private val mapper: MealsMapper
): IMealRepository {
  override suspend fun getCategories(): List<Category> {
    return withContext(Dispatchers.IO) {
      mapper.mapCategoriesDB(api.getCategories())
    }
  }

  override suspend fun getMeals(category: String): List<MealItem> {
    return withContext(Dispatchers.IO) {
      mapper.mapMealsDB(api.getMeals(category))
    }
  }

  override suspend fun getMealDetails(meal: String): List<MealItemDetails> {
    return withContext(Dispatchers.IO) {
      mapper.mapMealsDetailsDB(api.getMealDetails(meal))
    }
  }
}