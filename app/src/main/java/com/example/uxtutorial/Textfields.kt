package com.example.uxtutorial

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Height
import androidx.compose.material.icons.outlined.MonitorWeight
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ShowTextFields() {
  Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    var weightVal by remember { mutableStateOf("") }
    var weightValErr by remember { mutableStateOf(false) }

    weightValErr = weightVal.isEmpty() ||
      weightVal.toIntOrNull() == null ||
      weightVal.toInt() < 0 ||
      weightVal.toInt() > 250

    TextField(
      value = weightVal,
      onValueChange = { weightVal = it },
      textStyle = LocalTextStyle.current.copy(
        textAlign = TextAlign.Right
      ),

      //        label = {
      //          Text(text = "Enter your name")
      //        },

      placeholder = {
        Text(text = "Weight")
      },
      leadingIcon = {
        Icon(imageVector = Icons.Outlined.MonitorWeight, contentDescription = "Add icon")
      },
      suffix = {
        Text(text = "kg")
      },
      supportingText = if (weightValErr) {
        {
          Text(text = "* invalid input")
        }
      } else {
        null
      },
      isError = weightValErr,
      keyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Number,
        imeAction = ImeAction.Next
      ),
      keyboardActions = KeyboardActions(
        onNext = {
          println("Next clicked with value $weightVal")
        }
      )
    )

    Spacer(modifier = Modifier.height(20.dp))

    var outlinedVal by remember { mutableStateOf("") }
    var outlinedValErr by remember { mutableStateOf(false) }

    outlinedValErr = outlinedVal.isEmpty() ||
      outlinedVal.toIntOrNull() == null ||
      outlinedVal.toInt() < 0 ||
      outlinedVal.toInt() > 500

    OutlinedTextField(
      value = outlinedVal,
      onValueChange = { outlinedVal = it },
      textStyle = LocalTextStyle.current.copy(
        textAlign = TextAlign.Right
      ),
      placeholder = {
        Text(text = "Height")
      },
      leadingIcon = {
        Icon(imageVector = Icons.Outlined.Height, contentDescription = "Add icon")
      },
      suffix = {
        Text(text = "cm")
      },
      supportingText = if (outlinedValErr) {
        {
          Text(text = "* invalid input")
        }
      } else {
        null
      },
      isError = outlinedValErr,
      keyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Number,
        imeAction = ImeAction.Next
      ),
      keyboardActions = KeyboardActions(
        onNext = {
          println("Next clicked with value $outlinedVal")
        }
      )
    )
  }
}
