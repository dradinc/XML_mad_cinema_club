package com.dradinc.kotlinxml_mad_cinemaclub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Вызываем OnBoarding при запуске приложения
        val onBoardingActivity = Intent(this@MainActivity, OnBoarding::class.java)
        startActivity(onBoardingActivity)

    }
}