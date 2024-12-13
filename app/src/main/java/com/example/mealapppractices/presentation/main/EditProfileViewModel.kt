package com.example.mealapppractices.presentation.main

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealapppractices.domain.model.Grade
import com.example.mealapppractices.domain.repository.IProfileRepository
import com.example.mealapppractices.presentation.state.EditProfileState
import kotlinx.coroutines.launch

class EditProfileViewModel(
  private val repository: IProfileRepository
): ViewModel() {

  private val mutableState = MutableEditProfileState()
  val viewState = mutableState as EditProfileState

  init {
    viewModelScope.launch {
      repository.getProfile()?.let {
        mutableState.photoUri = Uri.parse(it.photoUri)
        mutableState.name = it.name
        mutableState.portfolioUrl = it.url
        mutableState.position = it.position
        mutableState.grade = it.grade
      }
    }
    mutableState.isNeedToShowPermission = true
  }

  fun onNameChanged(name: String) {
    mutableState.name = name
  }

  fun onPositionChange(position: String) {
    mutableState.position = position
  }

  fun onGradeChange(grade: Grade) {
    mutableState.grade = grade
  }

  fun onUrlChanged(url: String) {
    mutableState.portfolioUrl = url
  }

  fun onDoneClicked() {
    viewModelScope.launch {
      repository.setProfile(
        mutableState.photoUri.toString(),
        viewState.name,
        viewState.portfolioUrl,
        viewState.position,
        viewState.grade
      )
    }
  }

  fun onImageSelected(uri: Uri?) {
    uri?.let { mutableState.photoUri = it }
  }

  fun onPermissionClosed() {
    mutableState.isNeedToShowPermission = false
  }

  fun onAvatarClicked() {
    mutableState.isNeedToShowSelect = true
  }

  fun onSelectDismiss() {
    mutableState.isNeedToShowSelect = false
  }

  private class MutableEditProfileState: EditProfileState {
    override var photoUri: Uri by mutableStateOf(Uri.EMPTY)
    override var name: String by mutableStateOf("")
    override var portfolioUrl: String by mutableStateOf("")
    override var position: String by mutableStateOf("")
    override var grade: Grade by mutableStateOf(Grade.UNRECOGNIZED)
    override var isNeedToShowPermission: Boolean by mutableStateOf(false)
    override var isNeedToShowSelect: Boolean by mutableStateOf(false)
  }
}