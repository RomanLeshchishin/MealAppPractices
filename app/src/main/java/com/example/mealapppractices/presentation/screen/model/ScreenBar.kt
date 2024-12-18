package com.example.mealapppractices.presentation.screen.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ScreenBar (
  val route: String,
  val title: String? = null,
  val setIcon: ImageVector? = null,
  val unsetIcon: ImageVector? = null
){

  data object Main : ScreenBar(
    route = MAIN_ROUTE,
    title = MAIN_TITLE,
    setIcon = MAIN_SET_ICON,
    unsetIcon = MAIN_UNSET_ICON
  )

  data object Profile : ScreenBar(
    route = PROFILE_ROUTE,
    title = PROFILE_TITLE,
    setIcon = PROFILE_SET_ICON,
    unsetIcon = PROFILE_UNSET_ICON
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

    private const val MAIN_ROUTE = "main"
    private const val MAIN_TITLE = "Блюда"
    private val MAIN_SET_ICON = Icons.Filled.AccountCircle
    private val MAIN_UNSET_ICON = Icons.Outlined.AccountCircle

    private const val PROFILE_ROUTE = "profile"
    private const val PROFILE_TITLE = "Профиль"
    private val PROFILE_SET_ICON = Icons.Filled.Face
    private val PROFILE_UNSET_ICON = Icons.Outlined.Face

    private const val FAVORITE_ROUTE = "favorite"
    private const val FAVORITE_TITLE = "Любимые блюда"
    private val FAVORITE_SET_ICON = Icons.Outlined.Favorite
    private val FAVORITE_UNSET_ICON = Icons.Filled.FavoriteBorder

    private const val SETTINGS_ROUTE = "settings"
    private const val SETTINGS_TITLE = "Настройки"
    private val SETTINGS_SET_ICON = Icons.Filled.Settings
    private val SETTINGS_UNSET_ICON = Icons.Outlined.Settings
  }
}