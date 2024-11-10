package com.example.mealapppractices.di

import com.example.mealapppractices.data.mapper.MealsMapper
import com.example.mealapppractices.data.repository.MealRepository
import com.example.mealapppractices.domain.repository.IMealRepository
import com.example.mealapppractices.presentation.main.CategoryViewModel
import com.example.mealapppractices.presentation.main.MealDetailsViewModel
import com.example.mealapppractices.presentation.main.MealViewModel
import org.koin.dsl.module
import org.koin.core.module.dsl.viewModel

val rootModule = module {
  single<IMealRepository> { MealRepository(get(), get()) }
  factory { MealsMapper() }
  viewModel { CategoryViewModel(get()) }
  viewModel { MealViewModel(get()) }
  viewModel { MealDetailsViewModel(get()) }
}