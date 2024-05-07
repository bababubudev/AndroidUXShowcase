package com.example.uxtutorial

import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DirectionsRailway
import androidx.compose.material.icons.outlined.Navigation
import androidx.compose.material.icons.outlined.RadioButtonChecked
import androidx.compose.material.icons.outlined.SelectAll
import androidx.compose.material.icons.outlined.TextFields
import androidx.compose.material.icons.outlined.VerticalAlignBottom
import androidx.compose.material.icons.outlined.VerticalAlignTop
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.uxtutorial.ui.theme.UXTutorialTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      UXTutorialTheme {
        Surface(
          color = MaterialTheme.colorScheme.background
        ) {
          RenderOptions(this)
        }
      }
    }
  }
}

@Composable
private fun RenderOptions(context: Context){
  val navController = rememberNavController()
  NavHost(navController = navController, startDestination = "home") {
    composable("home") { HomePage(navController) }
    composable("show_buttons") { ShowButtons() }
    composable("show_text_fields") { ShowTextFields() }
    composable("selection_components") { SelectionComponents() }
    composable("top_bar") { AppBar(navController) }
    composable("bottom_bar") { BottomBar(navController) }
    composable("navbar") { BottomNavbar() }
    composable("nav_rail") { NavRail(context = context) }
  }
}

@Composable
private fun HomePage(navController: NavController) {
  Column(
    modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    ElevatedButton(onClick = {
      navController.navigate("show_buttons")
    }) {
      Icon(imageVector = Icons.Outlined.RadioButtonChecked, contentDescription = "button")
      Spacer(modifier = Modifier.width(10.dp))
      Text(text = "Buttons showcase")
    }

    Spacer(modifier = Modifier.height(10.dp))

    ElevatedButton(onClick = {
      navController.navigate("show_text_fields")
    }) {
      Icon(imageVector = Icons.Outlined.TextFields, contentDescription = "text")
      Spacer(modifier = Modifier.width(10.dp))
      Text(text = "Text field showcase")
    }

    Spacer(modifier = Modifier.height(10.dp))

    ElevatedButton(onClick = {
      navController.navigate("selection_components")
    }) {
      Icon(imageVector = Icons.Outlined.SelectAll, contentDescription = "radio")
      Spacer(modifier = Modifier.width(10.dp))
      Text(text = "Selection showcase")
    }

    Spacer(modifier = Modifier.height(10.dp))

    ElevatedButton(onClick = {
      navController.navigate("top_bar")
    }) {
      Icon(imageVector = Icons.Outlined.VerticalAlignTop, contentDescription = "navbar")
      Spacer(modifier = Modifier.width(10.dp))
      Text(text = "Appbar showcase")
    }

    Spacer(modifier = Modifier.height(10.dp))

    ElevatedButton(onClick = {
      navController.navigate("bottom_bar")
    }) {
      Icon(imageVector = Icons.Outlined.VerticalAlignBottom, contentDescription = "navbar")
      Spacer(modifier = Modifier.width(10.dp))
      Text(text = "Appbar showcase")
    }

    Spacer(modifier = Modifier.height(10.dp))

    ElevatedButton(onClick = {
      navController.navigate("navbar")
    }) {
      Icon(imageVector = Icons.Outlined.Navigation, contentDescription = "navbar")
      Spacer(modifier = Modifier.width(10.dp))
      Text(text = "Navbar showcase")
    }

    Spacer(modifier = Modifier.height(10.dp))

    ElevatedButton(onClick = {
      navController.navigate("nav_rail")
    }) {
      Icon(imageVector = Icons.Outlined.DirectionsRailway, contentDescription = "navbar")
      Spacer(modifier = Modifier.width(10.dp))
      Text(text = "Navrail showcase")
    }

  }
}
