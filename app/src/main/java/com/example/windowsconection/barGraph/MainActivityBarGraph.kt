package com.example.windowsconection.barGraph

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.echo.holographlibrary.Bar
import com.echo.holographlibrary.BarGraph
import com.example.windowsconection.barGraph.classes.DrawClass
import com.example.windowsconection.barGraph.classes.DateClass
import com.example.windowsconection.databinding.ActivityMainBinding
import android.util.Log
import android.app.AlertDialog
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import com.example.windowsconection.R

class MainActivityBarGraph : AppCompatActivity() {

    private val puntos: ArrayList<Bar> = ArrayList()
    private lateinit var btnAddComponent: Button
    private lateinit var btnLimpiarComponent: Button
    private lateinit var btnCambiarTituloComponent: Button
    private lateinit var btnEliminarUltimoComponent: Button
    private lateinit var editAttributeComponent: EditText
    private lateinit var editCuantityComponent: EditText
    private lateinit var graphTitleComponent: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.bar_graph_main)

        val draw = DrawClass()
        val year = DateClass()

        btnAddComponent = findViewById(R.id.btnAdd)
        btnLimpiarComponent = findViewById(R.id.btnLimpiar)
        btnCambiarTituloComponent = findViewById(R.id.btnCambiarTitulo)
        btnEliminarUltimoComponent = findViewById(R.id.btnEliminarUltimo)
        editAttributeComponent = findViewById(R.id.editAttribute)
        editCuantityComponent = findViewById(R.id.editCuantity)
        graphTitleComponent = findViewById(R.id.graphTitle)

        btnAddComponent.setOnClickListener(){
            val attributeText = editAttributeComponent.text.toString().trim()
            val quantityText = editCuantityComponent.text.toString().trim()

            if (attributeText.isEmpty()) {
                editAttributeComponent.error = "El atributo no puede estar vacío"
                return@setOnClickListener // Sale del click listener
            }

            val success = draw.graficarBarras(puntos, attributeText, quantityText)

            if(success){
                graphTitleComponent.text = "Gráfico de Muestra ${year.getCurrentYear()}"

                var text1 = draw.generarColorHexAleatorio()
                Log.d("ColorGenerado", "El color hexadecimal aleatorio es: $text1")

                val grafica = findViewById<View>(R.id.graphBar) as BarGraph
                grafica.bars = puntos
                grafica.postInvalidate() // Forzar redibujado del gráfico para asegurar la actualización

                // Limpiar campos para la siguiente entrada
                editAttributeComponent.text.clear()
                editCuantityComponent.text.clear()
                editAttributeComponent.requestFocus()
            }else{
                editCuantityComponent.error = "Por favor, introduce un número válido para la cantidad (ej. 10.5)"
                Log.e("MainActivity", "Error de entrada: Cantidad no válida.")
            }
        }

        btnLimpiarComponent.setOnClickListener(){
            graphTitleComponent.text = ""
            puntos.clear()
            val grafica = findViewById<BarGraph>(R.id.graphBar)
            grafica.bars = puntos // Asigna la lista vacía al gráfico
            grafica.postInvalidate() // Fuerza el redibujado
            Log.d("MainActivity", "Gráfico limpiado.")
        }

        btnCambiarTituloComponent.setOnClickListener(){
            // Crea un EditText para que el usuario ingrese el nuevo título
            val inputEditText = EditText(this)
            inputEditText.hint = "Nuevo título del gráfico"
            // Opcional: Establece el texto actual como valor por defecto en el EditText
            inputEditText.setText(graphTitleComponent.text)

            // Crea un LinearLayout para envolver el EditText y añadirle padding
            val container = LinearLayout(this)
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            // Añade un padding alrededor del EditText dentro del diálogo
            params.setMargins(50, 0, 50, 0) // izq, arriba, der, abajo
            container.layoutParams = params
            container.addView(inputEditText, params)


            AlertDialog.Builder(this).apply {
                setTitle("Cambiar Título del Gráfico")
                // Establece la vista personalizada (el EditText) para el diálogo
                setView(container) // O simplemente setView(inputEditText) si no quieres padding extra

                setPositiveButton("Aceptar") { dialog, _ ->
                    val newTitle = inputEditText.text.toString().trim()
                    if (newTitle.isNotEmpty()) {
                        graphTitleComponent.text = newTitle
                        Toast.makeText(this@MainActivityBarGraph, "Título actualizado", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this@MainActivityBarGraph, "El título no puede estar vacío", Toast.LENGTH_SHORT).show()
                    }
                    dialog.dismiss() // Cierra el diálogo
                }

                setNegativeButton("Cancelar") { dialog, _ ->
                    dialog.cancel() // Cancela el diálogo
                }
                show() // Muestra el diálogo
            }
        }

        btnEliminarUltimoComponent.setOnClickListener(){
            if (puntos.isNotEmpty()) {
                puntos.removeAt(puntos.size - 1) // Elimina el último elemento
                val grafica = findViewById<BarGraph>(R.id.graphBar)
                grafica.bars = puntos
                grafica.postInvalidate()
                Log.d("MainActivity", "Último registro eliminado.")
                Toast.makeText(this, "Último registro eliminado", Toast.LENGTH_SHORT).show()
            } else {
                // Si la lista está vacía, informa al usuario
                Toast.makeText(this, "No hay registros para eliminar", Toast.LENGTH_SHORT).show()
                Log.d("MainActivity", "Intento de eliminar de gráfico vacío.")
            }

            if (puntos.isEmpty()){
                graphTitleComponent.text=""
            }
        }
    }

}