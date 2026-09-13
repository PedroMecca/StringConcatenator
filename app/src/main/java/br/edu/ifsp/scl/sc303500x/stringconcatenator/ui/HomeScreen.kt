package br.edu.ifsp.scl.sc303500x.stringconcatenator.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    currentString: String,
    onAddWordClick: () -> Unit,
    onResetClick: () -> Unit
) {
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
            label = { Text("String atual") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = onAddWordClick, modifier = Modifier.fillMaxWidth()) {
            Text("Adicionar palavra")
        }

        OutlinedButton(onClick = onResetClick, modifier = Modifier.fillMaxWidth()) {
            Text("Reiniciar")
        }
    }
}