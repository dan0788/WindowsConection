package com.example.windowsconection

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.windowsconection.barGraph.MainActivityBarGraph
import com.example.windowsconection.transform.layouts.FindBinary
import com.example.windowsconection.transform.layouts.FindHexadecimal
import com.example.windowsconection.musicPlayer.MainActivityMusicPlayer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

    }

    fun returnToInicio(view: View){
        val intent = Intent(this, MainActivity::class.java).apply {  }
        startActivity(intent)
    }

    fun goToHexadecimal(view: View){
        val intent = Intent(this, FindHexadecimal::class.java).apply {  }
        startActivity(intent)
    }

    fun goToBinary(view: View){
        val intent = Intent(this, FindBinary::class.java).apply {  }
        startActivity(intent)
    }

    fun goToMusicPlayer(view: View){
        val intent = Intent(this, MainActivityMusicPlayer::class.java).apply {  }
        startActivity(intent)
    }

    fun goToBarGraph(view: View){
        val intent = Intent(this, MainActivityBarGraph::class.java).apply {  }
        startActivity(intent)
    }
}