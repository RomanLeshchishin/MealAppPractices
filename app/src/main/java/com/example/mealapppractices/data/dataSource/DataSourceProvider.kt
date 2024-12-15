package com.example.mealapppractices.data.dataSource

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.example.mealapppractices.data.serializer.ProfileSerializer
import com.example.mealapppractices.domain.model.ProfileEntity

class DataSourceProvider(val context: Context) {
  private val Context.profileDataStore: DataStore<ProfileEntity> by dataStore(
    fileName = "profile.pb",
    serializer = ProfileSerializer
  )

  fun provide() = context.profileDataStore
}