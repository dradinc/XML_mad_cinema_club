package com.dradinc.kotlinxml_mad_cinemaclub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.dradinc.kotlinxml_mad_cinemaclub.helpers.SharedPreferencesHelper
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    // Объявляем переменную для контролера навигации
    private lateinit var navController: NavController

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

        // Делаем так, чтобы переключались фрагменты
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        navController = navHostFragment.navController
        setupWithNavController(findViewById<BottomNavigationView>(R.id.bottomNavView), navController)

    }
}