package com.dradinc.kotlinxml_mad_cinemaclub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dradinc.kotlinxml_mad_cinemaclub.helpers.SharedPreferencesHelper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // переменная для взаимодейтсвия с памятью
        val appSharedPreferencesHelper = SharedPreferencesHelper(this)
        // Проверяем, что OnBoarding не был ещё завершон
        if (!appSharedPreferencesHelper.getBooleanData("is_OnBoarding")){
            // Вызываем OnBoarding при запуске приложения
            val onBoardingActivity = Intent(this@MainActivity, OnBoarding::class.java)
            startActivity(onBoardingActivity)
        }

    }
}