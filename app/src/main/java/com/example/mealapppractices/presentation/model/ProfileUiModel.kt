package com.example.mealapppractices.presentation.model

import android.net.Uri
import com.example.mealapppractices.domain.model.Grade

data class ProfileUiModel(
  val photoUri: Uri,
  val name: String,
  val position: String,
  val portfolioUrl: String,
  val grade: Grade,
  val gradeDescription: String
)
