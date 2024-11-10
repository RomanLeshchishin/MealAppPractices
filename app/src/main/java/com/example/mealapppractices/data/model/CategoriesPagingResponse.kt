package com.example.mealapppractices.data.model

import androidx.annotation.Keep

@Keep
data class CategoriesPagingResponse(
  val categories: List<CategoriesResponse?>?
)