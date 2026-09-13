package br.edu.ifsp.scl.sc303500x.stringconcatenator.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AddWordScreen(
    currentString: String,
    onConcatenateClick: (String) -> Unit
) {
    var word by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = currentString,
            onValueChange = {},
            readOnly = true,
            label = { Text("String recebida") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = word,
            onValueChange = { word = it },
            label = { Text("Nova palavra") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { onConcatenateClick(word) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Concatenar")
        }
    }
}