package com.example.mealapppractices.presentation.state

interface AreasState {
  val areas: List<String>
  val error: String?
  val loading: Boolean
}