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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.miniproyecto01.components.CustomRadioButton
import com.example.miniproyecto01.components.CustomSpinner
import com.example.miniproyecto01.components.CustomSwitch
import com.example.miniproyecto01.data.PreferencesManager
import com.example.miniproyecto01.model.Student

val BoxBorderColor = Color(0xFF000000)
val BoxBorderSize = 1.dp
val BoxColor = Color(0xFFCEC1FF)
val BoxTitleColor = BoxColor
val ButtonColor = Color(0xFFC5A8E7)

val AppBackground = Color(0xFFF4EEFD)

@Composable
fun RegisterStudent(
    onStudentSaved: () -> Unit = {}
) {
    // Instancia del gestor de SharedPreferences
    val context = LocalContext.current
    val preferencesManager = remember { PreferencesManager(context) }

    var matricula by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var carrera by remember { mutableStateOf("Lic. en Ing. de Software") }
    var turno by remember { mutableStateOf("Matutino") }
    var estatus by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppBackground)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier.height(4.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(BoxBorderSize, BoxBorderColor, RoundedCornerShape(20.dp))
                .clip(RoundedCornerShape(20.dp))
                .background(BoxTitleColor)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                textAlign = TextAlign.Center,
                text = "Registro de estudiantes",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.fillMaxWidth()
            )
        }

        HorizontalDivider()

        Spacer(modifier = Modifier.height(8.dp))

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .border(BoxBorderSize, BoxBorderColor, RoundedCornerShape(20.dp))
                .background(BoxColor)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Matricula", style = MaterialTheme.typography.titleMedium)

            OutlinedTextField(
                textStyle = MaterialTheme.typography.bodyMedium,
                value = matricula,
                onValueChange = { matricula = it },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFFFFFFF),
                    unfocusedContainerColor = Color(0xFFFFFFFF),
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                )
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .border(BoxBorderSize, BoxBorderColor, RoundedCornerShape(20.dp))
                .background(BoxColor)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Nombre Completo", style = MaterialTheme.typography.titleMedium)

            OutlinedTextField(
                textStyle = MaterialTheme.typography.bodyMedium,
                value = nombre,
                onValueChange = { nombre = it },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFFFFFFF),
                    unfocusedContainerColor = Color(0xFFFFFFFF),
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                )
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .border(BoxBorderSize, BoxBorderColor, RoundedCornerShape(20.dp))
                .background(BoxColor)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Carrera", style = MaterialTheme.typography.titleMedium)
            CustomSpinner(
                selectedText = carrera,
                onTextSelected = { carrera = it }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .border(BoxBorderSize, BoxBorderColor, RoundedCornerShape(20.dp))
                .background(BoxColor)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Turno", style = MaterialTheme.typography.titleMedium)
            CustomRadioButton(
                selectedOption = turno,
                onOptionSelected = { turno = it }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .border(BoxBorderSize, BoxBorderColor, RoundedCornerShape(20.dp))
                .background(BoxColor)
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            CustomSwitch(
                isChecked = estatus,
                onCheckedChange = { estatus = it }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonColors(
                containerColor = ButtonColor,
                contentColor = Color(0xFF000000),
                disabledContentColor = ButtonColor,
                disabledContainerColor = Color(0xFF000000)
            ),
            onClick = {
                if (matricula.isNotBlank() && nombre.isNotBlank()) {
                    val student = Student(
                        matricula = matricula,
                        nombre = nombre,
                        carrera = carrera,
                        turno = turno,
                        estatus = estatus
                    )
                    // Guardar los datos ingresados en SharedPreferences
                    preferencesManager.saveStudent(student)
                    onStudentSaved()
                }
            }
        ) {
            Text(
                textAlign = TextAlign.Center,
                text = "Enviar",
                fontSize = 20.sp,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
