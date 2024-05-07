package com.example.uxtutorial

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabRowComposable() {
  val tabItems = listOf(
    TabItem(
      title = "Home",
      unselectedIcon = Icons.Outlined.Home,
      selectedIcon = Icons.Filled.Home,
    ),
    TabItem(
      title = "Browse",
      unselectedIcon = Icons.Outlined.ShoppingCart,
      selectedIcon = Icons.Filled.ShoppingCart,
    ),
    TabItem(
      title = "Account",
      unselectedIcon = Icons.Outlined.AccountCircle,
      selectedIcon = Icons.Filled.AccountCircle,
    )
  )

  var selectedTabInd by remember { mutableIntStateOf(0) }
  var pagerState = rememberPagerState { tabItems.size }

  LaunchedEffect(selectedTabInd) {
    pagerState.animateScrollToPage(selectedTabInd)
  }

  LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
    if (!pagerState.isScrollInProgress) {
      selectedTabInd = pagerState.currentPage
    }
  }
  
  Column(
    modifier = Modifier.fillMaxSize(),
  ){
    TabRow(
      selectedTabIndex = selectedTabInd,
      modifier = Modifier.statusBarsPadding()
    ) {
      tabItems.forEachIndexed{ind, tabItems ->
        Tab(
          selected = ind == selectedTabInd,
          onClick = { selectedTabInd = ind },
          text = {
            Text(text = tabItems.title)
          },
          icon = {
            Icon(
              imageVector = if (ind == selectedTabInd) tabItems.selectedIcon else tabItems.unselectedIcon,
              contentDescription = tabItems.title
            )
          }
        )
      }
    }
    
    HorizontalPager(
      state = pagerState,
      modifier = Modifier
        .fillMaxWidth()
        .weight(1f),
    ) {ind ->
      Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
      ) {
        Text(text = tabItems[ind].title)
      }
    }
    
  }
}