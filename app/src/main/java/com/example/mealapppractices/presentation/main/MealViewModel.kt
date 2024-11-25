package com.example.mealapppractices.presentation.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealapppractices.coroutinesUtils.launchLoadingAndError
import com.example.mealapppractices.domain.repository.IMealRepository
import com.example.mealapppractices.presentation.model.MealItem
import com.example.mealapppractices.presentation.state.MealState

class MealViewModel(
  private val repository: IMealRepository
): ViewModel() {

  private val mutableMealState = MutableMealState()
  val viewState = mutableMealState as MealState

  private fun loadMeals() {
    viewModelScope.launchLoadingAndError(
      handleError = { mutableMealState.error = it.localizedMessage },
      updateLoading = { mutableMealState.loading = it }
    ) {
      mutableMealState.meals = emptyList()
      mutableMealState.error = null

      mutableMealState.meals = repository.getMealsByCategory(viewState.category)
    }
  }

  fun onCategoryClick(category: String) {
    mutableMealState.category = category
    loadMeals()
  }

  fun onReloadClicked() {
    loadMeals()
  }

  private class MutableMealState: MealState {
    override var meals: List<MealItem> by mutableStateOf(emptyList())
    override var category: String by mutableStateOf("")
    override var error: String? by mutableStateOf(null)
    override var loading: Boolean by mutableStateOf(false)
  }
}