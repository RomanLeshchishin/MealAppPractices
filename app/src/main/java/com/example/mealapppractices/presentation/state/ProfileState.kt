package com.example.mealapppractices.presentation.state

import androidx.compose.runtime.Stable
import com.example.mealapppractices.presentation.model.ProfileUiModel

@Stable
interface ProfileState {
  val profile: ProfileUiModel
}