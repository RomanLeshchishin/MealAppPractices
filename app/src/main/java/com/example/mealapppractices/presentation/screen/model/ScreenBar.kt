package com.example.mealapppractices.presentation.screen.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
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

  data object Notifications : ScreenBar(
    route = NOTIFICATIONS_ROUTE,
    title = NOTIFICATIONS_TITLE,
    setIcon = NOTIFICATIONS_SET_ICON,
    unsetIcon = NOTIFICATIONS_UNSET_ICON
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

    private const val NOTIFICATIONS_ROUTE = "notifications"
    private const val NOTIFICATIONS_TITLE = "Уведомления"
    private val NOTIFICATIONS_SET_ICON = Icons.Filled.Notifications
    private val NOTIFICATIONS_UNSET_ICON = Icons.Outlined.Notifications
  }
}