package com.example.mealapppractices.domain.repository

import com.example.mealapppractices.domain.model.Grade
import com.example.mealapppractices.domain.model.ProfileEntity
import kotlinx.coroutines.flow.Flow

interface IProfileRepository {
  suspend fun getProfile(): ProfileEntity?
  suspend fun setProfile(photoUri: String, name: String, url: String, position: String, grade: Grade): ProfileEntity
  suspend fun observeProfile(): Flow<ProfileEntity>
}