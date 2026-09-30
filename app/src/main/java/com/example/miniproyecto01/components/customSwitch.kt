package com.example.miniproyecto01.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun CustomSwitch(
    // Estado del interruptor recibido desde el formulario padre (State Hoisting)
    isChecked: Boolean,
    // Callback para notificar cambios en el interruptor
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("Estudiante Alta/Baja", fontSize = 16.sp, style = MaterialTheme.typography.titleMedium)
        Switch(
            checked = isChecked,
            onCheckedChange = onCheckedChange
        )
    }
}
