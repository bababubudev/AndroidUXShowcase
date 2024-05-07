package com.example.uxtutorial

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp

@Composable
fun SelectionComponents() {
  Column (
    modifier = Modifier.fillMaxSize().padding(20.dp),
    verticalArrangement = Arrangement.Center,
  ){
    Checkboxes()
    Spacer(modifier = Modifier.height(32.dp))
    MySwitch()
    Spacer(modifier = Modifier.height(32.dp))
    RadioButtons()
  }
}

@Composable
fun Checkboxes() {
  var checkboxes by remember { mutableStateOf(
    listOf(
      ToggleableInfo(false, "Images"),
      ToggleableInfo(false, "Videos"),
      ToggleableInfo(false, "Audios")
    )
  )
  }

  var triState by remember {
    mutableStateOf(ToggleableState.Indeterminate)
  }

  val toggleTriState = {
    triState = when(triState) {
      ToggleableState.Indeterminate -> ToggleableState.On
      ToggleableState.On -> ToggleableState.Off
      else -> ToggleableState.On
    }

    checkboxes.indices.forEach { ind ->
      checkboxes = checkboxes.toMutableList().also {
        it[ind] = checkboxes[ind].copy(isChecked = triState == ToggleableState.On)
      }
    }
  }

  Row(
    verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier
      .clickable { toggleTriState() }
      .padding(end = 16.dp)
  ) {
    TriStateCheckbox(
      state = triState,
      onClick = toggleTriState
    )
    Text(text = "File types")
  }


  checkboxes.forEachIndexed { ind, info ->
    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier
        .padding(start = 32.dp)
        .clickable {
          checkboxes = checkboxes
            .toMutableList()
            .also {
              it[ind] = info.copy(isChecked = !info.isChecked)
            }
        }
        .padding(end = 16.dp)
    ) {
      Checkbox(
        checked = info.isChecked,
        onCheckedChange = { checked ->
          checkboxes = checkboxes.toMutableList().also {
            it[ind] = info.copy(isChecked = checked)
          }
        }
      )
      Text(text = info.text)
    }
  }
}

@Composable
private fun MySwitch() {
  var switch by remember {
    mutableStateOf(
      ToggleableInfo(
        isChecked = false,
        text = "Dark mode"
      )
    )
  }

  Row(
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Text(text = switch.text)
    Spacer(modifier = Modifier.weight(1F))
    Switch(
      checked = switch.isChecked,
      onCheckedChange = { checked ->
        switch = switch.copy(isChecked = checked)
      },
      thumbContent = {
        Icon(
          imageVector = if (switch.isChecked) Icons.Default.Check else Icons.Default.Close,
          contentDescription = "Add icon"
        )
      }
    )
  }
}

@Composable
private fun RadioButtons() {
  val radioButtons = remember {
    mutableStateListOf(
      ToggleableInfo(
        isChecked = true,
        text = "Images"
      ),
      ToggleableInfo(
        isChecked = false,
        text = "Videos"
      ),
      ToggleableInfo(
        isChecked = false,
        text = "Audios"
      )
    )
  }

  radioButtons.forEachIndexed { _, info ->
    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier
        .clickable {
          radioButtons.replaceAll {
            it.copy(isChecked = it.text == info.text)
          }
        }
        .padding(end = 16.dp)
    ) {
      RadioButton(
        selected = info.isChecked,
        onClick = {
          radioButtons.replaceAll {
            it.copy(isChecked = it.text == info.text )
          }
        }
      )
      Text(text = info.text)
    }
  }
}