package com.example.mealapppractices.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.mealapppractices.data.model.MealDbEntity

@Dao
interface MealsDao {
  @Query("SELECT * FROM MealDbEntity")
  suspend fun getAll(): List<MealDbEntity>

  @Insert
  suspend fun insert(MealDbEntity: MealDbEntity)

  @Query("DELETE FROM MealDbEntity WHERE mealId = :mealId")
  suspend fun delete(mealId: String)
}