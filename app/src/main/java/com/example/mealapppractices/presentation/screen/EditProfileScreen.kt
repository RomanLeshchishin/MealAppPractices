package com.example.mealapppractices.presentation.screen

import android.Manifest
import android.app.AlertDialog
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Environment
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.window.Dialog
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.navigation.NavHostController
import com.example.mealapppractices.presentation.main.EditProfileViewModel
import com.example.mealapppractices.R
import org.koin.androidx.compose.koinViewModel
import java.io.File
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen(
  navController: NavHostController
) {
  val context = LocalContext.current

  val viewModel = koinViewModel<EditProfileViewModel>()
  val state = viewModel.viewState

  var imageUri by remember { mutableStateOf<Uri?>(null) }

  val pickMedia: ActivityResultLauncher<PickVisualMediaRequest> =
    rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
      viewModel.onImageSelected(uri)
    }

  val requestPermissionLauncher =
    rememberLauncherForActivityResult(
      ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
      if (!isGranted) {
        val dialog = AlertDialog.Builder(context)
          .setMessage("Пожалуйста, предоставьте разрешение на доступ к файлам на устройстве.")
          .setCancelable(false)
          .setPositiveButton("OK") { _, _ ->
          }.setNeutralButton("NO"){_, _, ->
            navController.popBackStack()
          }
        dialog.show()
      }
      viewModel.onPermissionClosed()
    }

  val mGetContent = rememberLauncherForActivityResult(
    ActivityResultContracts.TakePicture()
  ) { success: Boolean ->
    if (success) {
      viewModel.onImageSelected(imageUri)
    }
  }

  Scaffold(modifier = Modifier.fillMaxSize(),
    contentWindowInsets = WindowInsets(0.dp),
    topBar = {
      TopAppBar(
        title = {
          Text(text = "Редактирование профиля")
        },
        navigationIcon = {
          Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = null,
            Modifier
              .padding(end = 8.dp)
              .clickable { navController.popBackStack() }
          )
        },
        actions = {
          Icon(
            imageVector = Icons.Default.Done,
            contentDescription = null,
            Modifier
              .padding(end = 8.dp)
              .clickable {
                navController.popBackStack()
                viewModel.onDoneClicked()
              }
          )
        },
        modifier = Modifier.shadow(elevation = 1.dp)
      )
    }
  ) { padding ->
    Column(
      modifier = Modifier
        .padding(padding)
        .padding(horizontal = 16.dp)
        .fillMaxWidth()
    ) {
      AsyncImage(
        model = state.photoUri,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
          .padding(top = 16.dp)
          .size(128.dp)
          .clip(CircleShape)
          .clickable { viewModel.onAvatarClicked() },
        error = painterResource(R.drawable.mobile_phone)
      )
      TextField(
        value = state.name,
        onValueChange = { viewModel.onNameChanged(it) },
        label = { Text("ФИО") },
        modifier = Modifier
          .fillMaxWidth()
          .padding(top = 16.dp)
      )
      TextField(
        value = state.position,
        onValueChange = { viewModel.onPositionChange(it) },
        label = { Text("Должность") },
        modifier = Modifier
          .fillMaxWidth()
          .padding(top = 16.dp)
      )
      TextField(
        value = state.portfolioUrl,
        onValueChange = { viewModel.onUrlChanged(it) },
        label = { Text("Ссылка") },
        modifier = Modifier
          .fillMaxWidth()
          .padding(top = 16.dp)
      )
    }
  }

  if (state.isNeedToShowPermission) {
    LaunchedEffect(Unit) {
      if (ContextCompat.checkSelfPermission(
          context,
          Manifest.permission.WRITE_EXTERNAL_STORAGE
        ) != PackageManager.PERMISSION_GRANTED
      ) {
        requestPermissionLauncher.launch(
          Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
      }
    }
  }

  fun onCameraSelected() {
    val baseDir = Environment.getExternalStoragePublicDirectory(
      Environment.DIRECTORY_PICTURES
    )
    val pictureFile = File(baseDir, "picture_${Date().time}.jpg")
    imageUri = FileProvider.getUriForFile(
      context,
      context.packageName + ".provider",
      pictureFile
    )
    imageUri?.let { mGetContent.launch(it) }
  }

  if (state.isNeedToShowSelect) {
    Dialog(onDismissRequest = { viewModel.onSelectDismiss() }) {
      Surface(
        modifier = Modifier.fillMaxWidth(0.8f),
        shape = RoundedCornerShape(10.dp)
      ) {
        Column(modifier = Modifier.padding(10.dp)) {
          Text(
            text = "Камера",
            Modifier.clickable {
              onCameraSelected()
              viewModel.onSelectDismiss()
            }
          )
          Text(text = "Галерея",
            Modifier.clickable {
              pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
              viewModel.onSelectDismiss()
            })
        }
      }
    }
  }
}