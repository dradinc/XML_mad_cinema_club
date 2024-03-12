package com.dradinc.kotlinxml_mad_cinemaclub.helpers

import android.content.Context

class SharedPreferencesHelper(context: Context) {

    // Переменная для сохранения и получения из памяти
    private val appSharedPreferences = context.getSharedPreferences("APP_PREF", Context.MODE_PRIVATE)

    // Сохранение строковых данных
    public fun saveData(key: String, value: String) {
        val editor = appSharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    // Получение строковых значений
    public fun getStringData(key: String): String? {
        return appSharedPreferences.getString(key, "")
    }

    // Получение булевых значений
    public fun getBooleanData(key: String): Boolean {
        return appSharedPreferences.getBoolean(key, false)
    }

    // Сохранение булевых данных
    public fun saveData(key: String, value: Boolean) {
        val editor = appSharedPreferences.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    // Очистка всех значений
    public fun clearData() {
        val editor = appSharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

}