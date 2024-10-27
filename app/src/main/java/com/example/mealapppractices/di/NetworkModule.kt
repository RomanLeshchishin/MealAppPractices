package com.example.mealapppractices.di

import com.example.mealapppractices.data.api.MealApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import org.koin.dsl.module
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
  factory { provideRetrofit() }
  single { provideNetworkApi(get()) }
}

fun provideRetrofit(): Retrofit {
  return Retrofit.Builder()
    .baseUrl("www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create())
    .client(OkHttpClient.Builder().build())
    .build()
}

fun provideNetworkApi(retrofit: Retrofit): MealApi =
  retrofit.create(MealApi::class.java)