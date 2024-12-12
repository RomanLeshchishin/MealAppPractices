package com.example.mealapppractices.presentation.mapper

import android.net.Uri
import com.example.mealapppractices.domain.model.ProfileEntity
import com.example.mealapppractices.presentation.model.ProfileUiModel
import com.example.mealapppractices.R
import com.example.mealapppractices.domain.model.Grade

class ProfileUIMapper {
  fun mapProfile(profile: ProfileEntity): ProfileUiModel {
    return ProfileUiModel(
      name = profile.name,
      photoUri = Uri.parse(profile.photoUri),
      position = profile.position,
      grade = profile.grade,
      portfolioUrl = profile.url,
      gradeDescription = when (profile.grade) {
        Grade.FIRST_CATEGORY -> R.string.first_grade
        Grade.SECOND_CATEGORY -> R.string.second_grade
        Grade.THIRD_CATEGORY -> R.string.third_grade
        Grade.FOURTH_CATEGORY -> R.string.fourth_grade
        Grade.FIFTH_CATEGORY -> R.string.fifth_grade
        Grade.SIXTH_CATEGORY -> R.string.sixth_grade
        else -> R.string.no_grade
      }.toString()
    )
  }
}