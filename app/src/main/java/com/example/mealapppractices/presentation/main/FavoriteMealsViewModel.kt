package com.example.mealapppractices.presentation.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealapppractices.domain.repository.IMealRepository
import com.example.mealapppractices.presentation.model.MealItemDetails
import com.example.mealapppractices.presentation.state.FavoriteMealsState
import kotlinx.coroutines.launch

class FavoriteMealsViewModel(
  private val repository: IMealRepository
): ViewModel() {

  private var favoriteMeals: List<MealItemDetails> = emptyList()

  private val mutableFavoriteState = MutableFavoriteMealsState()
  val viewState = mutableFavoriteState as FavoriteMealsState

  init {
    loadFavoriteMeals()
  }

  private fun loadFavoriteMeals() {
    viewModelScope.launch {
      favoriteMeals = repository.getSavedMeals()
      mutableFavoriteState.favoriteMeals = favoriteMeals
    }
  }

  private class MutableFavoriteMealsState: FavoriteMealsState {
    override var favoriteMeals: List<MealItemDetails> by mutableStateOf(emptyList())
  }
}