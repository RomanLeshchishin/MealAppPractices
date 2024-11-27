package com.example.mealapppractices.presentation.extension

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Info
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.mealapppractices.presentation.screen.model.ScreenBar


@Composable
fun RowScope.AddItem(
  screen: ScreenBar,
  destination: NavDestination?,
  navController: NavHostController,
  isBadge: Boolean
) {
  NavigationBarItem(
    selected = destination?.hierarchy?.any {
      it.route == screen.route
    } == true,
    onClick = {
      navController.navigate(screen.route) {
        popUpTo(navController.graph.findStartDestination().id)
        launchSingleTop = true
      }
    },
    icon = {
      BadgedBox(
        badge = {
          if (isBadge && screen.title == ScreenBar.Settings.title) {
            Badge ()
          }
        }
      ) {
        Icon(
          imageVector = if (destination?.hierarchy?.any {
              it.route == screen.route
            } == true
          ) {
            screen.setIcon
          } else {
            screen.unsetIcon
          } ?: Icons.TwoTone.Info,
          contentDescription = screen.title
        )
      }
    },
    label = {
      Text(
        text = screen.title ?: "Неизвестно"
      )
    },
    alwaysShowLabel = false
  )
}