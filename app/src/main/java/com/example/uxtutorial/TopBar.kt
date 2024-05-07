package com.example.uxtutorial

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(navController: NavController) {
  val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
  Scaffold(
    modifier = Modifier.fillMaxSize().nestedScroll(scrollBehavior.nestedScrollConnection),
    topBar = {
      TopAppBar(
        title = { Text("App bar") },
        navigationIcon = {
          IconButton(onClick = { navController.navigate("home") }) {
            Icon(
              imageVector = Icons.Outlined.ArrowBackIosNew,
              contentDescription = "Back home"
            )
          }
        },
        actions = {
          IconButton(onClick = { /* doSomething() */ }) {
            Icon(
              imageVector = Icons.Outlined.FavoriteBorder,
              contentDescription = "Mark as favorite"
            )
          }
          IconButton(onClick = { /* doSomething() */ }) {
            Icon(
              imageVector = Icons.Outlined.Edit,
              contentDescription = "Edit notes"
            )
          }
        },
        scrollBehavior = scrollBehavior,

      )
    }
  ) { values ->
    LazyColumn(

      modifier = Modifier
        .fillMaxSize()
        .padding(values)
    ) {
      items(20) {
        Text(
          text = "Item $it",
          modifier = Modifier.padding(16.dp)
        )
      }
    }
  }
}