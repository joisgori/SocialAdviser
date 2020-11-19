package com.example.socialadviser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class AppLogic : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_logic)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.nav_bar)
        val navController = findNavController(R.id.nav_app_logic)

        bottomNavigationView.setupWithNavController(navController)
    }
}