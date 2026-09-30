package com.example.miniproyecto01.data

import android.content.Context
import android.content.SharedPreferences
import com.example.miniproyecto01.model.Student

class PreferencesManager(context: Context) {
    // 1. Instancia de SharedPreferences
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("StudentPrefs", Context.MODE_PRIVATE)

    // 2. Función para GUARDAR un estudiante
    fun saveStudent(student: Student) {
        val editor = sharedPreferences.edit()
        editor.putString("KEY_MATRICULA", student.matricula)
        editor.putString("KEY_NOMBRE", student.nombre)
        editor.putString("KEY_CARRERA", student.carrera)
        editor.putString("KEY_TURNO", student.turno)
        editor.putBoolean("KEY_ESTATUS", student.estatus)
        editor.putBoolean("KEY_IS_SAVED", true) // Bandera para saber si hay un registro guardado
        editor.apply() // Guarda en segundo plano
    }

    // 3. Función para LEER el estudiante guardado
    fun getStudent(): Student? {
        val isSaved = sharedPreferences.getBoolean("KEY_IS_SAVED", false)
        if (!isSaved) return null

        return Student(
            matricula = sharedPreferences.getString("KEY_MATRICULA", "") ?: "",
            nombre = sharedPreferences.getString("KEY_NOMBRE", "") ?: "",
            carrera = sharedPreferences.getString("KEY_CARRERA", "") ?: "",
            turno = sharedPreferences.getString("KEY_TURNO", "") ?: "",
            estatus = sharedPreferences.getBoolean("KEY_ESTATUS", false)
        )
    }

    // 4. Función para BORRAR los datos cuando se requiera registrar un nuevo estudiante
    fun clearStudent() {
        sharedPreferences.edit().clear().apply()
    }
}