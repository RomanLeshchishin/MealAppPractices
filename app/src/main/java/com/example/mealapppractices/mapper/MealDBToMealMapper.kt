package com.example.mealapppractices.mapper

import com.example.mealapppractices.data.MealItemDetailsDB
import com.example.mealapppractices.presentation.model.Ingredient
import com.example.mealapppractices.presentation.model.MealItemDetails

class MealDBToMealMapper {
  fun mapMealItemDetailsDB(mealDetails: MealItemDetailsDB): MealItemDetails {
    return MealItemDetails(
      id = mealDetails.idMeal,
      title = mealDetails.strMeal,
      drinkAlternate = mealDetails.strDrinkAlternate,
      category = mealDetails.strCategory,
      area = mealDetails.strArea,
      instructions = mealDetails.strInstructions,
      imgUrl = mealDetails.strMealThumb,
      tags = mealDetails.strTags.split(','),
      videoUrl = mealDetails.strYoutube,
      ingredients = listOf(
        Ingredient(mealDetails.strIngredient1, mealDetails.strMeasure1),
        Ingredient(mealDetails.strIngredient2, mealDetails.strMeasure2),
        Ingredient(mealDetails.strIngredient3, mealDetails.strMeasure3),
        Ingredient(mealDetails.strIngredient4, mealDetails.strMeasure4),
        Ingredient(mealDetails.strIngredient5, mealDetails.strMeasure5)
      )
    )
  }
}