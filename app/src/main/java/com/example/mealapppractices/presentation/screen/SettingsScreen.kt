package com.example.mealapppractices.presentation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavHostController
import com.example.mealapppractices.presentation.handlers.SettingsScreenHandler
import com.example.mealapppractices.presentation.main.AreasViewModel
import com.example.mealapppractices.presentation.main.MainViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun SettingsScreen(navController: NavHostController) {
  val areaViewModel = koinViewModel<AreasViewModel>()
  val areaState = areaViewModel.viewState
  val mainViewModel = koinViewModel<MainViewModel>()
  val mainState = mainViewModel.viewState
  val handler = SettingsScreenHandler(navController)
  var expanded by remember { mutableStateOf(false) }
  var textfieldSize by remember { mutableStateOf(Size.Zero)}
  var setSelectedText by remember { mutableStateOf("") }
  val icon = if (expanded)
    Icons.Filled.KeyboardArrowUp
  else
    Icons.Filled.KeyboardArrowDown

  Text(text = "Settings Screen", modifier = Modifier.padding(16.dp))
  Column(Modifier.padding(20.dp)) {
    Column(Modifier.padding(20.dp)) {
      OutlinedTextField(
        value = mainState.area,
        onValueChange = {  setSelectedText = it },
        modifier = Modifier
          .fillMaxWidth()
          .onGloballyPositioned { coordinates ->
            textfieldSize = coordinates.size.toSize()
          },
        label = {Text("Label")},
        trailingIcon = {
          Icon(icon,"contentDescription",
            Modifier.clickable { expanded = !expanded })
        }
      )
      DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false },
        modifier = Modifier
          .width(with(LocalDensity.current){textfieldSize.width.toDp()})
      ) {
        areaState.areas.forEach { label ->
          DropdownMenuItem(
            text = { Text(label) },
            onClick = {
              setSelectedText = label
              mainViewModel.onAreaChange(label)
              expanded = false
            },
          )
        }
      }
    }
    Row {
      Button(
        onClick = { mainViewModel.onRemoveClicked() },
        Modifier.padding(all = 5.dp)
      ) {
        Text(
          text = "Сбросить",
          color = Color.Black
        )
      }
      Spacer(modifier = Modifier.width(100.dp))
      Button(
        onClick = { handler.onToSave() },
        Modifier.padding(all = 5.dp)
      ) {
        Text(
          text = "Сохранить",
          color = Color.Black
        )
      }
    }
  }
}