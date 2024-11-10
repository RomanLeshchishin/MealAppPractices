package com.example.mealapppractices.presentation.screen.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ScreenBar (
  val route: String,
  val title: String? = null,
  val setIcon: ImageVector? = null,
  val unsetIcon: ImageVector? = null
){

  data object Categories : ScreenBar(
    route = CATEGORIES_ROUTE,
    title = CATEGORIES_TITLE,
    setIcon = CATEGORIES_SET_ICON,
    unsetIcon = CATEGORIES_UNSET_ICON
  )

  data object Home : ScreenBar(
    route = HOME_ROUTE,
    title = HOME_TITLE,
    setIcon = HOME_SET_ICON,
    unsetIcon = HOME_UNSET_ICON
  )

  data object Favorite : ScreenBar(
    route = FAVORITE_ROUTE,
    title = FAVORITE_TITLE,
    setIcon = FAVORITE_SET_ICON,
    unsetIcon = FAVORITE_UNSET_ICON
  )

  data object Settings : ScreenBar(
    route = SETTINGS_ROUTE,
    title = SETTINGS_TITLE,
    setIcon = SETTINGS_SET_ICON,
    unsetIcon = SETTINGS_UNSET_ICON
  )

  companion object{
    private const val CATEGORIES_ROUTE = "categories"
    private const val CATEGORIES_TITLE = "Категории блюд"
    private val CATEGORIES_SET_ICON = Icons.Filled.AccountCircle
    private val CATEGORIES_UNSET_ICON = Icons.Outlined.AccountCircle

    private const val HOME_ROUTE = "home"
    private const val HOME_TITLE = "Домашняя страница"
    private val HOME_SET_ICON = Icons.Filled.Home
    private val HOME_UNSET_ICON = Icons.Outlined.Home

    private const val FAVORITE_ROUTE = "favorite"
    private const val FAVORITE_TITLE = "Любимые блюда"
    private val FAVORITE_SET_ICON = Icons.Filled.Favorite
    private val FAVORITE_UNSET_ICON = Icons.Outlined.Favorite

    private const val SETTINGS_ROUTE = "settings"
    private const val SETTINGS_TITLE = "Настройки"
    private val SETTINGS_SET_ICON = Icons.Filled.Settings
    private val SETTINGS_UNSET_ICON = Icons.Outlined.Settings
  }
}