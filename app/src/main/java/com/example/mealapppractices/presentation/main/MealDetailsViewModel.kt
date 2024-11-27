package com.example.mealapppractices.presentation.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.mealapppractices.domain.repository.IMealRepository
import com.example.mealapppractices.presentation.model.MealItemDetails
import com.example.mealapppractices.presentation.state.MealDetailsState
import androidx.lifecycle.viewModelScope
import com.example.mealapppractices.coroutinesUtils.launchLoadingAndError
import kotlinx.coroutines.launch

class MealDetailsViewModel(
  private val repository: IMealRepository
): ViewModel() {

  private var favoriteMeals: List<MealItemDetails> = emptyList()

  private val mutableMealDetailsState = MutableMealDetailsState()
  val viewState = mutableMealDetailsState as MealDetailsState

  private fun loadMealsDetails() {
    viewModelScope.launchLoadingAndError(
      handleError = { mutableMealDetailsState.error = it.localizedMessage },
      updateLoading = { mutableMealDetailsState.loading = it }
    ) {
      mutableMealDetailsState.mealsDetails = emptyList()
      mutableMealDetailsState.error = null

      favoriteMeals = repository.getSavedMeals()
      mutableMealDetailsState.mealsDetails = repository.getMealsDetailsById(viewState.mealId)
    }
  }

  fun onMealItemClick(id: Int) {
    mutableMealDetailsState.mealId = id
    loadMealsDetails()
  }

  fun onReloadClicked() {
    loadMealsDetails()
  }

  fun onFavoriteClicked(mealId: Int) {
    val meal = favoriteMeals.find { it.id == mealId.toString() }
    if (meal != null) {
      viewModelScope.launch {
        repository.deleteMeal(mutableMealDetailsState.mealsDetails.first())
      }
    }
    else {
      viewModelScope.launch {
        repository.saveMeal(mutableMealDetailsState.mealsDetails.first())
      }
    }
  }

  fun getIsFavorite(mealId: String): Boolean {
    val meal = favoriteMeals.find { it.id == mealId }
    return meal != null
  }

  private class MutableMealDetailsState: MealDetailsState {
    override var mealsDetails: List<MealItemDetails> by mutableStateOf(emptyList())
    override var mealId: Int by mutableIntStateOf(0)
    override var error: String? by mutableStateOf(null)
    override var loading: Boolean by mutableStateOf(false)
  }
}