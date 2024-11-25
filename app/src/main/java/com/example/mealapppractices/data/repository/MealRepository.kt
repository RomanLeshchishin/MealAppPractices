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

  override suspend fun getMealsByCategory(category: String): List<MealItem> {
    return withContext(Dispatchers.IO) {
      mapper.mapMealsDB(api.getMealsByCategory(category))
    }
  }

  override suspend fun getMealsByArea(area: String): List<MealItem> {
    return withContext(Dispatchers.IO) {
      mapper.mapMealsDB(api.getMealsByArea(area))
    }
  }

  override suspend fun getMealsByIngredient(ingredient: String): List<MealItem> {
    return withContext(Dispatchers.IO) {
      mapper.mapMealsDB(api.getMealsByIngredient(ingredient))
    }
  }

  override suspend fun getAreas(): List<String> {
    return withContext(Dispatchers.IO) {
      mapper.mapAreasDB(api.getAreas())
    }
  }

  override suspend fun getIngredients(): List<String> {
    return withContext(Dispatchers.IO) {
      mapper.mapIngredientsDB(api.getIngredients())
    }
  }

  override suspend fun getMealsDetailsById(id: Int): List<MealItemDetails> {
    return withContext(Dispatchers.IO) {
      mapper.mapMealsDetailsDB(api.getMealsDetailsById(id))
    }
  }
}