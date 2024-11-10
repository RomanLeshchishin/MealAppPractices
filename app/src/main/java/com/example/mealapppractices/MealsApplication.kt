package com.example.mealapppractices

import android.app.Application
import com.example.mealapppractices.di.networkModule
import com.example.mealapppractices.di.rootModule
import org.koin.core.context.startKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class MealsApplication : Application() {
  override fun onCreate() {
    super.onCreate()
    startKoin {
      androidLogger()
      androidContext(this@MealsApplication)
      modules(rootModule, networkModule)
    }
  }
}