package com.example.mealapppractices.presentation.state

import androidx.compose.runtime.Stable

@Stable
interface AreasState {
  val areas: List<String>
  val error: String?
  val loading: Boolean
}