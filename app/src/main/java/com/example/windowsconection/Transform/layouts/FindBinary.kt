package com.example.windowsconection.Transform.layouts

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import com.example.examen.R
import android.os.Bundle
import android.view.View
//import com.example.examen.MainActivity
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.text.isDigitsOnly
import com.example.windowsconection.Transform.classes.TransformCharactersClass

class FindBinary : AppCompatActivity() {

    private lateinit var transformCharactersClass: TransformCharactersClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.find_binary)

        var btnTransform : Button = findViewById(R.id.btnTransform)
        var textView4 : TextView = findViewById(R.id.textView4)
        var inputTextComponent : EditText = findViewById(R.id.inputText)

        transformCharactersClass = TransformCharactersClass()

        btnTransform.setOnClickListener(){
            var string = inputTextComponent.text.toString()
            if (string.isEmpty() || !string.isDigitsOnly()){
                inputTextComponent.error = "Los valores ingresados deben ser numeros enteros"
                textView4.text = ""
                return@setOnClickListener
            }

            var value = transformCharactersClass.transformToBinary(string)
            textView4.text = "$value"
        }

    }
}