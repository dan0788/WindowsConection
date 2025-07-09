package com.example.windowsconection.transform.layouts

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.windowsconection.R
import android.os.Bundle
import android.view.View
import com.example.windowsconection.MainActivity
import android.content.Intent
import com.example.windowsconection.transform.classes.TransformCharactersClass
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import com.example.windowsconection.transform.classes.ValuesClass

class FindHexadecimal : AppCompatActivity() {

    private lateinit var transformCharactersClass: TransformCharactersClass
    private lateinit var valuesClass : ValuesClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.find_hexadecimal)

        var inputText1Component : EditText = findViewById(R.id.inputText1)
        var inputText2Component : EditText = findViewById(R.id.inputText2)
        var inputText3Component : EditText = findViewById(R.id.inputText3)
        var textView5Component : TextView = findViewById(R.id.textView5)
        var btnSumar : Button = findViewById(R.id.btnSumar)

        transformCharactersClass = TransformCharactersClass()
        valuesClass = ValuesClass()

        btnSumar.setOnClickListener(){
            var inputText1Value = inputText1Component.text.toString()
            var inputText2Value = inputText2Component.text.toString()
            var inputText3Value = inputText3Component.text.toString()

            if (inputText1Value.isEmpty() && inputText2Value.isEmpty() && inputText3Value.isEmpty()){
                inputText1Component.error = "Debe ingresar al menos un valor"
                textView5Component.text = ""
                return@setOnClickListener
            }

            var matrix : MutableList<Char> = inputText1Value.toMutableList()
            var hexValues = valuesClass.hexadecimalValues()
            for (i in matrix){
                if(!hexValues.containsKey(i.uppercaseChar())){
                    inputText1Component.error = "$i no es un valor hexadecimal"
                    textView5Component.text = ""
                    return@setOnClickListener
                    break
                }
            }

            matrix = inputText2Value.toMutableList()
            for (i in matrix){
                if(!hexValues.containsKey(i.uppercaseChar())){
                    inputText2Component.error = "$i no es un valor hexadecimal"
                    textView5Component.text = ""
                    return@setOnClickListener
                    break
                }
            }

            matrix = inputText3Value.toMutableList()
            for (i in matrix){
                if(!hexValues.containsKey(i.uppercaseChar())){
                    inputText3Component.error = "$i no es un valor hexadecimal"
                    textView5Component.text = ""
                    break
                }
            }

            var value1 = transformCharactersClass.transformToHexadecimal(inputText1Component.text.toString())
            var value2 = transformCharactersClass.transformToHexadecimal(inputText2Component.text.toString())
            var value3 = transformCharactersClass.transformToHexadecimal(inputText3Component.text.toString())

            var result = value1 + value2 + value3
            textView5Component.text = "El valor decimal de la suma de los valores ingresados es: $result"

        }


    }

    fun returnToInicio(view: View){
        val intent = Intent(this, MainActivity::class.java).apply {  }
        startActivity(intent)
    }
}