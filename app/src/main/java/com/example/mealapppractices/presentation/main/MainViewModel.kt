package com.example.mealapppractices.presentation.main

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealapppractices.coroutinesUtils.launchLoadingAndError
import com.example.mealapppractices.domain.repository.IMealRepository
import com.example.mealapppractices.presentation.model.Category
import com.example.mealapppractices.presentation.model.MealItem
import com.example.mealapppractices.presentation.state.MainState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class MainViewModel(
  private val repository: IMealRepository,
  private val context: Context
): ViewModel() {

  val DEFAULT_AREA = stringPreferencesKey("default_area")
  val defaultAreaFlow: Flow<String> = getPreferences(DEFAULT_AREA)
  private val mutableMainState = MutableMainState()
  val viewState = mutableMainState as MainState

  init {
    viewModelScope.launch {
      defaultAreaFlow.collect {
        setArea(it)
      }
    }
    loadMealsByArea()
  }

  private fun loadMealsByArea() {
    viewModelScope.launchLoadingAndError(
      handleError = { mutableMainState.error = it.localizedMessage },
      updateLoading = { mutableMainState.loading = it }
    ) {
      mutableMainState.mealsByArea = emptyList()
      mutableMainState.categories = emptyList()
      mutableMainState.error = null

      if (viewState.area == "") {
        mutableMainState.categories = repository.getCategories()
      }
      else {
        mutableMainState.mealsByArea = repository.getMealsByArea(viewState.area)
      }
    }
  }

  fun setArea(area: String){
    mutableMainState.area = area
    loadMealsByArea()
  }

  fun onAreaChange(area: String) {
    viewModelScope.launch {
      savePreferences(DEFAULT_AREA, area)
    }
    setArea(area)
  }

  fun onReloadClicked() {
    loadMealsByArea()
  }

  fun onRemoveClicked() {
    viewModelScope.launch {
      savePreferences(DEFAULT_AREA, "")
    }
    setArea("")
  }

  private class MutableMainState: MainState {
    override var categories: List<Category> by mutableStateOf(emptyList())
    override var mealsByArea: List<MealItem> by mutableStateOf(emptyList())
    override var area: String by mutableStateOf("")
    override var error: String? by mutableStateOf(null)
    override var loading: Boolean by mutableStateOf(false)
  }

  private fun getPreferences(key: Preferences.Key<String>): Flow<String> {
    return context.dataStore.data
      .map { preferences ->
        preferences[key] ?: ""
      }
  }

  private suspend fun savePreferences(key: Preferences.Key<String>, value: String) {
    context.dataStore.edit { settings ->
      settings[key] = value
    }
  }
}