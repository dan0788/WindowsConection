package com.example.windowsconection.transform.layouts

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.windowsconection.R
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.text.isDigitsOnly
import com.example.windowsconection.transform.classes.TransformCharactersClass

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