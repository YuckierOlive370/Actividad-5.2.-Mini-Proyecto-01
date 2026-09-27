package com.example.miniproyecto01

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
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
    estatus: String
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
    }
}