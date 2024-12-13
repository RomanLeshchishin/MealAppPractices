package com.example.mealapppractices.presentation.screen

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.example.mealapppractices.R
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.mealapppractices.presentation.main.ProfileViewModel
import com.example.mealapppractices.presentation.screen.model.ScreenBar
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
  val viewModel = koinViewModel<ProfileViewModel>()
  val state = viewModel.viewState

  val context = LocalContext.current

  Scaffold(modifier = Modifier.fillMaxSize(),
    contentWindowInsets = WindowInsets(0.dp),
    topBar = {
      TopAppBar(
        title = {
          Text(text = ScreenBar.Profile.title ?: "Нет названия")
        },
        actions = {
          Icon(
            imageVector = Icons.Default.Edit,
            contentDescription = null,
            Modifier
              .padding(end = 8.dp)
              .clickable { }
          )
        }
      )
    }) { padding ->
    Column(
    modifier = Modifier
      .padding(padding)
      .fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    AsyncImage(
      model = state.profile.photoUri,
      contentDescription = null,
      contentScale = ContentScale.Crop,
      modifier = Modifier
        .clip(CircleShape)
        .size(128.dp),
      error = painterResource(R.drawable.mobile_phone)
    )
    Text(text = state.profile.name, style = MaterialTheme.typography.titleLarge)
    Text(text = state.profile.position, style = MaterialTheme.typography.titleLarge)
    Button(onClick = { enqueueDownloadRequest(state.profile.portfolioUrl, context) }) {
      Text(text = "Резюме")
    }
    Text(text = state.profile.grade.name, style = MaterialTheme.typography.titleLarge)
    Text(text = state.profile.gradeDescription, style = MaterialTheme.typography.titleLarge)
    }
  }
}

private fun enqueueDownloadRequest(
  url: String,
  context: Context
) {
  val request: DownloadManager.Request = DownloadManager.Request(Uri.parse(url))
  with(request) {
    setTitle("Test pdf")
    setMimeType("pdf")
    setDescription("Downloading pdf...")
    setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
    setDestinationInExternalPublicDir(
      Environment.DIRECTORY_DOWNLOADS,
      "test.pdf"
    )
  }
  val manager: DownloadManager =
    context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
  manager.enqueue(request)
}