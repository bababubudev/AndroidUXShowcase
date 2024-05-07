package com.example.uxtutorial

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavDrawer(navController: NavController){
  val items = listOf(
    NavSidebar(
      title = "Home",
      route = "home",
      selectedIcon = Icons.Filled.Home,
      unselectedIcon = Icons.Outlined.Home,
      hasNews = false
    ),
    NavSidebar(
      title = "Urgent",
      selectedIcon = Icons.Filled.Info,
      unselectedIcon = Icons.Outlined.Info,
      hasNews = false,
      badgeCount = 45
    ),
    NavSidebar(
      title = "Settings",
      selectedIcon = Icons.Filled.Settings,
      unselectedIcon = Icons.Outlined.Settings,
      hasNews = false
    )
  )

  val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
  val scope = rememberCoroutineScope()
  var selectedItemInd by rememberSaveable {
    mutableStateOf(1)
  }

  ModalNavigationDrawer(
    drawerContent = {
      ModalDrawerSheet {
        Spacer(modifier = Modifier.height(10.dp))
        items.forEachIndexed { ind, item ->
          NavigationDrawerItem(
            label = {
              Text(text = item.title)
            },
            selected = ind == selectedItemInd,
            onClick = {
              item.route?.let { navController.navigate(it) }
              selectedItemInd = ind
              scope.launch {
                drawerState.close()
              }
            },
            icon = {
              Icon(
                imageVector = if (ind == selectedItemInd) item.selectedIcon else item.unselectedIcon,
                contentDescription = item.title
              )
            },
            badge = {
              item.badgeCount?.let {
                Text(text = item.badgeCount.toString())
              }
            },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
          )
        }
      }
    },
    drawerState = drawerState,
  ) {
    Scaffold(
      topBar = {
        TopAppBar(
          title = { Text("Side drawer") },
          navigationIcon = {
            IconButton(onClick = {scope.launch { drawerState.open() }} ) {
              Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
            }
          }
        )
      }
    ) {
    }
  }
}