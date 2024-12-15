package com.example.mealapppractices.presentation.state

import android.net.Uri
import com.example.mealapppractices.domain.model.Grade

interface EditProfileState {
  val photoUri: Uri
  val name: String
  val portfolioUrl: String
  val position: String
  val grade: Grade
  val isNeedToShowPermission: Boolean
  val isNeedToShowSelect: Boolean
}