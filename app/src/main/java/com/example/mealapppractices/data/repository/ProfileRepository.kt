package com.example.mealapppractices.data.repository

import androidx.datastore.core.DataStore
import com.example.mealapppractices.domain.model.Grade
import com.example.mealapppractices.domain.model.ProfileEntity
import com.example.mealapppractices.domain.repository.IProfileRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import org.koin.core.qualifier.named
import org.koin.java.KoinJavaComponent.inject

class ProfileRepository: IProfileRepository {
  private val dataStore : DataStore<ProfileEntity> by inject(DataStore::class.java, named("profile"))

  override suspend fun observeProfile(): Flow<ProfileEntity> = dataStore.data

  override suspend fun getProfile(): ProfileEntity? = dataStore.data.firstOrNull()

  override suspend fun setProfile(photoUri: String, name: String, url: String, position: String, grade: Grade) =
    dataStore.updateData {
      it.toBuilder().apply {
        this.photoUri = photoUri
        this.name = name
        this.url = url
        this.position = position
        this.grade = grade
      }.build()
    }
}