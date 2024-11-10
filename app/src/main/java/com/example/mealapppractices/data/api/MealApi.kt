package com.example.mealapppractices.data.api

import com.example.mealapppractices.data.model.CategoriesPagingResponse
import com.example.mealapppractices.data.model.MealsDetailsPagingResponse
import com.example.mealapppractices.data.model.MealsPagingResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApi {
  @GET("categories.php")
  suspend fun getCategories(): CategoriesPagingResponse

  @GET("filter.php")
  suspend fun getMeals(@Query("c") category: String): MealsPagingResponse

  @GET("lookup.php")
  suspend fun getMealsDetailsById(@Query("i") id: Int): MealsDetailsPagingResponse
}