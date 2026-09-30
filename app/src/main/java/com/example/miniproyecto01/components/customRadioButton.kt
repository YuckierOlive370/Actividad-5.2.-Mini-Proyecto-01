package com.example.miniproyecto01.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomRadioButton(
    // Recibe la opción seleccionada desde el padre (State Hoisting)
    selectedOption: String,
    // Callback para notificar la nueva opción seleccionada
    onOptionSelected: (String) -> Unit
) {
    val turnos: Array<String> = arrayOf("Matutino", "Vespertino", "Nocturno")

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFFF5F5F5))
    ) {
        for (text in turnos) {
            RadioButton(
                modifier = Modifier.size(28.dp),
                selected = (selectedOption == text),
                onClick = { onOptionSelected(text) }
            )
            Text(
                text = text,
                modifier = Modifier.clickable { onOptionSelected(text) }
            )
            if (text != turnos.lastOrNull()) Spacer(modifier = Modifier.width(12.dp))
        }
    }
}
