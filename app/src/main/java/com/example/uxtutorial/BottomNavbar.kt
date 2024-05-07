package com.example.uxtutorial

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavbar() {
  val items = listOf(
    NavItem(
      title = "Home",
      selectedIcon = Icons.Filled.Home,
      unselectedIcon = Icons.Outlined.Home,
      hasNews = false
    ),
    NavItem(
      title = "Chat",
      selectedIcon = Icons.Filled.ChatBubble,
      unselectedIcon = Icons.Outlined.ChatBubbleOutline,
      hasNews = false,
      badgeCount = 45
    ),
    NavItem(
      title = "Settings",
      selectedIcon = Icons.Filled.Settings,
      unselectedIcon = Icons.Outlined.Settings,
      hasNews = true
    ),
  )

  var selectedItem by rememberSaveable {
    mutableStateOf(0)
  }

  Scaffold(
    bottomBar = {
      NavigationBar {
        items.forEachIndexed { ind, item ->
          NavigationBarItem(
            selected = selectedItem == ind,
            onClick = {
              selectedItem = ind
              // navController.navigate(item.title)
            },
            label = {
              Text(text = item.title)
            },
            icon = {
              BadgedBox(badge = {
                if (item.badgeCount != null) {
                  Badge {
                    Text(text = item.badgeCount.toString())
                  }
                } else if (item.hasNews) {
                  Badge()
                }
              }) {
                Icon(
                  imageVector = if (ind == selectedItem) item.selectedIcon else item.unselectedIcon,
                  contentDescription = "Selection icon"
                )
              }
            }
          )
        }
      }
    }
  ) {
  }
}