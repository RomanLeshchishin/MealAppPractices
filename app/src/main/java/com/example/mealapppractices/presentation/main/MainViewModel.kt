package com.example.mealapppractices.presentation.main

import androidx.lifecycle.ViewModel
import com.example.mealapppractices.data.MealItemDetailsExample
import com.example.mealapppractices.data.mapper.MealsMapper
import com.example.mealapppractices.domain.repository.IMealRepository
import com.example.mealapppractices.presentation.model.Category
import com.example.mealapppractices.presentation.model.MealItem
import com.example.mealapppractices.presentation.model.MealItemDetails

class MainViewModel(
  private val repository: IMealRepository
) : ViewModel() {
  private val _categories = mutableListOf<Category>()
  private val _mealItems = mutableListOf<List<MealItem>>()
  private val _mealItemDetails = mutableListOf<MealItemDetails>()

  val categories: List<Category>
    get () = _categories

  val mealItems: List<List<MealItem>>
    get () = _mealItems

  val mealItemDetails: List<MealItemDetails>
    get () = _mealItemDetails

  init {
    _categories.addAll(listOf(
      Category("1", "Beef", "https://www.themealdb.com/images/category/beef.png", "Beef is the culinary name for meat from cattle, particularly skeletal muscle."),
      Category("2", "Chicken", "https://www.themealdb.com/images/category/chicken.png", "Chicken is a type of domesticated fowl, a subspecies of the red junglefowl."),
      Category("3", "Dessert", "https://www.themealdb.com/images/category/dessert.png", "Dessert is a course that concludes a meal."),
      Category("4", "Lamb", "https://www.themealdb.com/images/category/lamb.png", "Lamb, hogget, and mutton are the meat of domestic sheep (species Ovis aries) at different ages."),
      Category("5", "Miscellaneous", "https://www.themealdb.com/images/category/miscellaneous.png", "General foods that don't fit into another category."),
    ))

    _mealItems.add(listOf(
      MealItem("52874", "Beef and Mustard Pie", "https://www.themealdb.com/images/media/meals/sytuqu1511553755.jpg"),
      MealItem("52878", "Beef and Oyster pie", "https://www.themealdb.com/images/media/meals/wrssvt1511556563.jpg"),
      MealItem("53071", "Beef Asado", "https://www.themealdb.com/images/media/meals/pkopc31683207947.jpg"),
    ))

    _mealItems.add(listOf(
      MealItem("53085", "15-minute chicken & halloumi burgers", "https://www.themealdb.com/images/media/meals/vdwloy1713225718.jpg"),
      MealItem("53050", "Ayam Percik", "https://www.themealdb.com/images/media/meals/020z181619788503.jpg"),
      MealItem("52940", "Brown Stew Chicken", "https://www.themealdb.com/images/media/meals/sypxpx1515365095.jpg"),
    ))

    _mealItemDetails.addAll(listOf(
      MealsMapper().mapMealsDetailsDB(MealItemDetailsExample[0]),
      MealsMapper().mapMealsDetailsDB(MealItemDetailsExample[1])
    ))
  }
}