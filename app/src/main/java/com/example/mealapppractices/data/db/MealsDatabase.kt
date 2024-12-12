package com.example.mealapppractices.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mealapppractices.data.dao.MealsDao
import com.example.mealapppractices.data.model.MealDbEntity

@Database(entities = [MealDbEntity::class], version = 1)
abstract class MealsDatabase : RoomDatabase() {
  abstract fun mealsDao(): MealsDao
}