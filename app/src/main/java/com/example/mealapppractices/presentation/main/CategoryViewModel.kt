package com.example.mealapppractices.presentation.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealapppractices.coroutinesUtils.launchLoadingAndError
import com.example.mealapppractices.domain.repository.IMealRepository
import com.example.mealapppractices.presentation.model.Category
import com.example.mealapppractices.presentation.state.CategoryState

class CategoryViewModel(
  private val repository: IMealRepository
) : ViewModel() {

  private val mutableState = MutableMainState()
  val viewState = mutableState as CategoryState

  init {
    loadCategories()
  }

  private fun loadCategories() {
    viewModelScope.launchLoadingAndError(
      handleError = { mutableState.error = it.localizedMessage },
      updateLoading = { mutableState.loading = it }
    ) {
      mutableState.categories = emptyList()
      mutableState.error = null

      mutableState.categories = repository.getCategories()
    }
  }

  fun onReloadClicked() {
    loadCategories()
  }

  private class MutableMainState: CategoryState {
    override var categories: List<Category> by mutableStateOf(emptyList())
    override var error: String? by mutableStateOf(null)
    override var loading: Boolean by mutableStateOf(false)
  }
}