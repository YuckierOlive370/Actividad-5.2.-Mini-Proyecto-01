package com.example.miniproyecto01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.example.miniproyecto01.data.PreferencesManager
import com.example.miniproyecto01.ui.theme.MiniProyecto01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Obtenemos el contexto actual de Android para instanciar el gestor de preferencias
            val context = LocalContext.current
            val preferencesManager = remember { PreferencesManager(context) }

            // Estado que sostiene al alumno guardado en SharedPreferences.
            // Si al iniciar existe un alumno, su valor será no-nulo (Student); si no hay ninguno, será null.
            var currentStudent by remember { mutableStateOf(preferencesManager.getStudent()) }

            MiniProyecto01Theme {
                if (currentStudent != null) {
                    // Si ya hay un estudiante guardado en SharedPreferences, mostramos la pantalla de confirmación
                    ConfirmationScreen(
                        matricula = currentStudent!!.matricula,
                        nombre = currentStudent!!.nombre,
                        carrera = currentStudent!!.carrera,
                        turno = currentStudent!!.turno,
                        estatus = if (currentStudent!!.estatus) "Activo" else "Inactivo",
                        onReset = {
                            // Limpia los datos persistidos en SharedPreferences y regresa al formulario
                            preferencesManager.clearStudent()
                            currentStudent = null
                        }
                    )
                } else {
                    // Si no hay datos almacenados, mostramos el formulario de registro
                    RegisterStudent(
                        onStudentSaved = {
                            // Al guardar, volvemos a leer SharedPreferences para actualizar el estado y cambiar a ConfirmationScreen
                            currentStudent = preferencesManager.getStudent()
                        }
                    )
                }
            }
        }
    }
}
