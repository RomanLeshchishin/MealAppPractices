package com.example.mealapppractices.presentation.model

class Area(
  val area: String
)

class Ingredient(
  val ingredient: String
)

class IngredientMeasure(
  val ingredient: String,
  val measure: String
)

data class Category(
  val id: String,
  val title: String,
  val imgUrl: String,
  val description: String
)

data class MealItem(
  val id: String,
  val title: String,
  val imgUrl: String
)

data class MealItemDetails(
  val id: String,
  val title: String,
  val drinkAlternate: String,
  val category: String,
  val area: String,
  val instructions: String,
  val imgUrl: String,
  val tags: List<String>,
  val videoUrl: String,
  val ingredients: List<IngredientMeasure>
)