package com.example.mealapppractices.di

import androidx.datastore.core.DataStore
import com.example.mealapppractices.data.dataSource.DataSourceProvider
import com.example.mealapppractices.data.mapper.MealsMapper
import com.example.mealapppractices.data.repository.MealRepository
import com.example.mealapppractices.data.repository.ProfileRepository
import com.example.mealapppractices.domain.model.ProfileEntity
import com.example.mealapppractices.domain.repository.IMealRepository
import com.example.mealapppractices.domain.repository.IProfileRepository
import com.example.mealapppractices.presentation.main.AreasViewModel
import com.example.mealapppractices.presentation.main.FavoriteMealsViewModel
import com.example.mealapppractices.presentation.main.MealDetailsViewModel
import com.example.mealapppractices.presentation.main.MainViewModel
import com.example.mealapppractices.presentation.main.MealViewModel
import org.koin.dsl.module
import org.koin.core.module.dsl.viewModel
import org.koin.core.qualifier.named

val rootModule = module {
  single<IMealRepository> { MealRepository(get(), get(), get()) }
  factory { MealsMapper() }

  single<IProfileRepository> { ProfileRepository() }
  factory<DataStore<ProfileEntity>>(named("profile")) { DataSourceProvider(get()).provide() }

  viewModel { MainViewModel(get(), get()) }

  viewModel { MealDetailsViewModel(get()) }

  viewModel { AreasViewModel(get(), get()) }

  viewModel { MealViewModel(get()) }

  viewModel { FavoriteMealsViewModel(get()) }
}