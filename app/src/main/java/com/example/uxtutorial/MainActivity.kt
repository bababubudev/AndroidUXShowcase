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
import androidx.compose.material.icons.outlined.ErrorOutline
import androidx.compose.material.icons.outlined.Menu
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
import androidx.compose.ui.graphics.vector.ImageVector
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
    composable("nav_drawer") { NavDrawer() }
  }
}

@Composable
private fun HomePage(navController: NavController) {
  val destinations = mapOf(
    "show_buttons" to "Buttons showcase",
    "show_text_fields" to "Text field showcase",
    "selection_components" to "Selection showcase",
    "top_bar" to "Appbar showcase",
    "bottom_bar" to "Appbar showcase",
    "navbar" to "Navbar showcase",
    "nav_rail" to "Navrail showcase",
    "nav_drawer" to "Navdraw showcase"
  )

  Column(
    modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    destinations.forEach { (route, title) ->
      ElevatedButton(onClick = {
        navController.navigate(route)
      }) {
        Icon(imageVector = getIconForRoute(route), contentDescription = route)
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = title)
      }

      Spacer(modifier = Modifier.height(10.dp))
    }
  }
}

private fun getIconForRoute(route: String): ImageVector {
  return when (route) {
    "show_buttons" -> Icons.Outlined.RadioButtonChecked
    "show_text_fields" -> Icons.Outlined.TextFields
    "selection_components" -> Icons.Outlined.SelectAll
    "top_bar" -> Icons.Outlined.VerticalAlignTop
    "bottom_bar" -> Icons.Outlined.VerticalAlignBottom
    "navbar" -> Icons.Outlined.Navigation
    "nav_rail" -> Icons.Outlined.DirectionsRailway
    "nav_drawer" -> Icons.Outlined.Menu
    else -> Icons.Outlined.ErrorOutline
  }
}
