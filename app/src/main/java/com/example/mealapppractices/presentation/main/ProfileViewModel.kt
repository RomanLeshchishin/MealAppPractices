package com.example.mealapppractices.presentation.main

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealapppractices.R
import com.example.mealapppractices.domain.model.Grade
import com.example.mealapppractices.domain.repository.IProfileRepository
import com.example.mealapppractices.presentation.mapper.ProfileUIMapper
import com.example.mealapppractices.presentation.model.ProfileUiModel
import com.example.mealapppractices.presentation.state.ProfileState
import kotlinx.coroutines.launch

class ProfileViewModel(
  private val repository: IProfileRepository,
  private val mapper: ProfileUIMapper
): ViewModel() {

  private val mutableProfileState = MutableProfileState()
  val viewState = mutableProfileState as ProfileState

  init {
    viewModelScope.launch{
      repository.observeProfile().collect {
        mutableProfileState.profile = mapper.mapProfile(it)
      }
    }
  }

  private class MutableProfileState: ProfileState {
    override var profile: ProfileUiModel by mutableStateOf(
      ProfileUiModel(
        photoUri = Uri.EMPTY,
        name = "",
        position = "",
        grade = Grade.UNRECOGNIZED,
        portfolioUrl = "",
        gradeDescription = R.string.no_grade.toString()
      )
    )
  }
}