package com.example.mealapppractices.data.mapper

import com.example.mealapppractices.data.model.CategoriesPagingResponse
import com.example.mealapppractices.data.model.MealsDetailsPagingResponse
import com.example.mealapppractices.data.model.MealsPagingResponse
import com.example.mealapppractices.presentation.model.Category
import com.example.mealapppractices.presentation.model.Ingredient
import com.example.mealapppractices.presentation.model.MealItem
import com.example.mealapppractices.presentation.model.MealItemDetails

class MealsMapper {
  fun mapCategoriesDB(categories: CategoriesPagingResponse): List<Category> {
    return categories.categories?.map {
      Category(
        id = it?.idCategory.orEmpty(),
        title = it?.strCategory.orEmpty(),
        imgUrl = it?.strCategoryThumb.orEmpty(),
        description = it?.strCategoryDescription.orEmpty()
      )
    }.orEmpty()
  }

  fun mapMealsDB(meals: MealsPagingResponse): List<MealItem> {
    return meals.meals?.map {
      MealItem(
        id = it?.idMeal.orEmpty(),
        title = it?.strMeal.orEmpty(),
        imgUrl = it?.strMealThumb.orEmpty()
      )
    }.orEmpty()
  }

  fun mapMealsDetailsDB(mealsDetails: MealsDetailsPagingResponse): List<MealItemDetails> {
    return mealsDetails.meals?.map {
      MealItemDetails(
        id = it?.idMeal.orEmpty(),
        title = it?.strMeal.orEmpty(),
        drinkAlternate = it?.strDrinkAlternate.orEmpty(),
        category = it?.strCategory.orEmpty(),
        area = it?.strArea.orEmpty(),
        instructions = it?.strInstructions.orEmpty(),
        imgUrl = it?.strMealThumb.orEmpty(),
        tags = it?.strTags?.split(',').orEmpty(),
        videoUrl = it?.strYoutube.orEmpty(),
        ingredients = listOf(
          Ingredient(it?.strIngredient1.orEmpty(), it?.strMeasure1.orEmpty()),
          Ingredient(it?.strIngredient2.orEmpty(), it?.strMeasure2.orEmpty()),
          Ingredient(it?.strIngredient3.orEmpty(), it?.strMeasure3.orEmpty()),
          Ingredient(it?.strIngredient4.orEmpty(), it?.strMeasure4.orEmpty()),
          Ingredient(it?.strIngredient5.orEmpty(), it?.strMeasure5.orEmpty())
        )
      )
    }.orEmpty()
  }
}