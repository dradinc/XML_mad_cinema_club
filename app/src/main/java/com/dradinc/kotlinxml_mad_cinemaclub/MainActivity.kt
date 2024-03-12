package com.dradinc.kotlinxml_mad_cinemaclub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Переменная для работы с сохранением данных
        val saveAppPref = getSharedPreferences("APP_PREF", MODE_PRIVATE)
        // Проверяем значение отображения OnBoarding
        if (!saveAppPref.getBoolean("is_onBoarding", false)) {
            // Если знаечние false, то показываем onBoarding
        }

    }
}