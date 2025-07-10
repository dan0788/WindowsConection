package com.example.windowsconection.barGraph.interfaces

import com.echo.holographlibrary.Bar
import com.example.windowsconection.databinding.ActivityMainBinding

interface DrawInterface {
    fun graficarBarras(puntos: ArrayList<Bar>, attribute: String, quantity: String) : Boolean
    fun generarColorHexAleatorio() : String
}