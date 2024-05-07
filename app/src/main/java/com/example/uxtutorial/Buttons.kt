package com.example.uxtutorial

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.ArrowOutward
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ShowButtons() {
  Column (
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ){
    Button(onClick = { /*TODO*/ }) {
      Text(text = "Create new account")
    }

    OutlinedButton(onClick = { /*TODO*/ }) {
      Text(text = "Use existing account")
    }

    ElevatedButton(onClick = { /*TODO*/ }) {
      Icon(imageVector = Icons.Outlined.Add, contentDescription = "Add icon")
      Spacer(modifier = Modifier.width(10.dp))
      Text(text = "Add to cart")
    }

    FilledTonalButton(onClick = { /*TODO*/ }) {
      Text(text = "Open in browser")
      Spacer(modifier = Modifier.width(10.dp))
      Icon(imageVector = Icons.Outlined.ArrowOutward, contentDescription = "Add icon")
    }

    TextButton(onClick = { /*TODO*/ }) {
      Text(text = "Learn more")
    }
  }
}
