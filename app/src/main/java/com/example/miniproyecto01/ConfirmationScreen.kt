package com.example.miniproyecto01

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ConfirmationScreen(
    matricula: String,
    nombre: String,
    carrera: String,
    turno: String,
    estatus: String,
    // Callback para resetear o borrar el estudiante guardado y regresar al formulario
    onReset: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppBackground)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    BoxBorderSize,
                    BoxBorderColor,
                    RoundedCornerShape(20.dp)
                )
                .clip(RoundedCornerShape(20.dp))
                .background(BoxTitleColor)
                .padding(16.dp)
        ) {
            Text(
                text = "Confirmación de Registro",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Muestra los datos recuperados de SharedPreferences
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    BoxBorderSize,
                    BoxBorderColor,
                    RoundedCornerShape(20.dp)
                )
                .clip(RoundedCornerShape(20.dp))
                .background(BoxColor)
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Matrícula: $matricula")
            Text("Nombre: $nombre")
            Text("Carrera: $carrera")
            Text("Turno: $turno")
            Text("Estatus: $estatus")
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Botón para resetear SharedPreferences y registrar a un nuevo estudiante
        Button(
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonColors(
                containerColor = ButtonColor,
                contentColor = Color(0xFF000000),
                disabledContentColor = ButtonColor,
                disabledContainerColor = Color(0xFF000000)
            ),
            onClick = onReset
        ) {
            Text(
                text = "Registrar otro alumno",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
