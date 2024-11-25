package com.example.mealapppractices.presentation.main

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealapppractices.coroutinesUtils.launchLoadingAndError
import com.example.mealapppractices.domain.repository.IMealRepository
import com.example.mealapppractices.presentation.state.AreasState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class AreasViewModel(
  private val repository: IMealRepository,
  private val context: Context
): ViewModel() {
  private val mutableAreaState = MutableAreasState()
  val viewState = mutableAreaState as AreasState

  init {
    loadAreas()
  }

  private fun loadAreas() {
    viewModelScope.launchLoadingAndError(
      handleError = { mutableAreaState.error = it.localizedMessage },
      updateLoading = { mutableAreaState.loading = it }
    ) {
      mutableAreaState.areas = emptyList()
      mutableAreaState.error = null

      mutableAreaState.areas = repository.getAreas()
    }
  }

  fun onReloadClicked() {
    loadAreas()
  }

  private class MutableAreasState: AreasState {
    override var areas: List<String> by mutableStateOf(emptyList())
    override var error: String? by mutableStateOf(null)
    override var loading: Boolean by mutableStateOf(false)
  }
}