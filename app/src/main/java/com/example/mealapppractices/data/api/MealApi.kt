package com.example.mealapppractices.data.api

import com.example.mealapppractices.data.model.CategoriesPagingResponse
import com.example.mealapppractices.data.model.MealsDetailsPagingResponse
import com.example.mealapppractices.data.model.MealsPagingResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MealApi {
  @GET("categories.php")
  suspend fun getCategories(): CategoriesPagingResponse

  @GET("filter.php?c={category}")
  suspend fun getMeals(@Path("category") category: String): MealsPagingResponse

  @GET("lookup.php?i={meal}")
  suspend fun getMealDetails(@Path("meal") meal: String): MealsDetailsPagingResponse

  @GET("search.php?s={meal}")
  suspend fun getMealSDetails(@Path("meal") meal: String): MealsDetailsPagingResponse
}