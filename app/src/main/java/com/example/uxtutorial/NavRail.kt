package com.example.uxtutorial

import android.app.Activity
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun NavRail(context: Context) {
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
    )
  )

  val windowClass = calculateWindowSizeClass(activity = LocalContext.current as Activity)

  // CHANGEME: Only for testing
  val showNavRail = windowClass.widthSizeClass == WindowWidthSizeClass.Compact
  var selectedItemInd by rememberSaveable {
    mutableStateOf(0)
  }

  Scaffold(
    bottomBar = {
      if (!showNavRail) {
//        NavigationRail()
      }
    },
    modifier = Modifier.fillMaxSize()
  ) {
    LazyColumn(
      modifier = Modifier
        .fillMaxSize()
        .padding(it)
        .padding(start = if (showNavRail) 80.dp else 0.dp)
    ) {     
      items(20) {
        Text(
          text = "Item $it",
          modifier = Modifier.padding(8.dp)
        )
      }
    }
  }

  if(showNavRail) {
    NavigationSidebar(
      items = items,
      selectedItemInd = selectedItemInd,
      onNavigate = { selectedItemInd = it }
    )
  }
}

@Composable
fun NavigationSidebar(
  items: List<NavItem>,
  selectedItemInd: Int,
  onNavigate: (Int) -> Unit
) {
  NavigationRail(
    header = {
      IconButton(onClick = { /*TODO*/ }) {
        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
      }
      FloatingActionButton(
        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation(),
        onClick = { /*TODO*/ }
      ) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Add button")
      }
    },
    modifier = Modifier
      .background(MaterialTheme.colorScheme.inverseOnSurface)
      .offset(x = (-1).dp)
  ) {
    Column(
      modifier = Modifier.fillMaxHeight(),
      verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Bottom)
    ) {
      items.forEachIndexed { index, item ->
        NavigationRailItem(
          selected = selectedItemInd == index,
          onClick = {onNavigate(index)},
          icon = {
            NavigationIcon(item = item, selected = selectedItemInd == index)
          },
          label = { Text(text = item.title) },
        )
      }
    }
  }
}

@Composable
fun NavigationIcon(
  item: NavItem,
  selected: Boolean,
) {
  BadgedBox(
    badge = {
      if (item.badgeCount != null) {
        Badge{
          Text(text = item.badgeCount.toString())
        }
      } else if (item.hasNews) {
        Badge()
      }
    }
  ) {
    Icon(
      if (selected) item.selectedIcon else item.unselectedIcon,
      contentDescription = item.title
    )
  }
}