package com.example.miniproyecto01.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun CustomSpinner(
    // Texto de la carrera seleccionada recibido desde el formulario padre (State Hoisting)
    selectedText: String,
    // Callback para notificar cuando el usuario selecciona una nueva carrera
    onTextSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                IconButton(onClick = { expanded = true }) {
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFFFFFFF),
                unfocusedContainerColor = Color(0xFFFFFFFF),
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black
            )
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            val carreras = listOf(
                "Lic. en Ing. Civil",
                "Lic. en Ing. Geodésica",
                "Lic. en Ing. de Software",
                "Lic. en Ing. en Proc. Industriales",
                "Lic. en Ing. en Nano. y Ene. Renov."
            )
            carreras.forEach { carrera ->
                DropdownMenuItem(
                    text = { Text(carrera) },
                    onClick = {
                        onTextSelected(carrera)
                        expanded = false
                    }
                )
            }
        }
    }
}
