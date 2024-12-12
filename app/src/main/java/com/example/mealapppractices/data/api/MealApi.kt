package com.example.mealapppractices.data.api

import com.example.mealapppractices.data.model.AreasPagingResponse
import com.example.mealapppractices.data.model.CategoriesPagingResponse
import com.example.mealapppractices.data.model.IngredientsPagingResponse
import com.example.mealapppractices.data.model.MealsDetailsPagingResponse
import com.example.mealapppractices.data.model.MealsPagingResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApi {
  @GET("categories.php")
  suspend fun getCategories(): CategoriesPagingResponse

  @GET("filter.php")
  suspend fun getMealsByCategory(@Query("c") category: String): MealsPagingResponse

  @GET("filter.php")
  suspend fun getMealsByArea(@Query("a") area: String): MealsPagingResponse

  @GET("filter.php")
  suspend fun getMealsByIngredient(@Query("i") ingredient: String): MealsPagingResponse

  @GET("list.php")
  suspend fun getAreas(@Query("a") area: String = "list"): AreasPagingResponse

  @GET("list.php")
  suspend fun getIngredients(@Query("i") area: String = "list"): IngredientsPagingResponse

  @GET("lookup.php")
  suspend fun getMealsDetailsById(@Query("i") id: Int): MealsDetailsPagingResponse
}