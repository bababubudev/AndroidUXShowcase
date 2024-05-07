package com.example.uxtutorial

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetComposable() {
  val scaffoldState = rememberBottomSheetScaffoldState()
  val scope = rememberCoroutineScope()

  Box(
    modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
  ) {
    Button(
      onClick = {
        scope.launch {
          scaffoldState.bottomSheetState.expand()
        }
      }
    ) {
      Text(text = "Open sheet")
    }

    BottomSheetScaffold(
      scaffoldState = scaffoldState,
      sheetContent = {
        Image(
          painter = painterResource(id = R.drawable.turtle),
          contentDescription = "turtle"
        )
      },
      sheetPeekHeight = 0.dp
    )
    {

    }
  }
}