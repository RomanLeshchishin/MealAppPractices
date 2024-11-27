package com.example.mealapppractices.di

import android.content.Context
import androidx.room.Room
import com.example.mealapppractices.data.db.MealsDatabase
import org.koin.dsl.module

val dbModule = module {
  single { DatabaseBuilder.getInstance(get()) }
}

object DatabaseBuilder {
  private var INSTANCE: MealsDatabase? = null

  fun getInstance(context: Context): MealsDatabase {
    if (INSTANCE == null) {
      synchronized(MealsDatabase::class) {
        INSTANCE = buildRoomDB(context)
      }
    }
    return INSTANCE!!
  }

  private fun buildRoomDB(context: Context) =
    Room.databaseBuilder(
      context.applicationContext,
      MealsDatabase::class.java,
      "meals-example"
    ).build()
}