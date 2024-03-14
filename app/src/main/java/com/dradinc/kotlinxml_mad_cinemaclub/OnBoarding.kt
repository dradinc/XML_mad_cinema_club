package com.dradinc.kotlinxml_mad_cinemaclub

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.dradinc.kotlinxml_mad_cinemaclub.helpers.SharedPreferencesHelper

class OnBoarding : AppCompatActivity() {
    // Переменные для взаимодействия с объектами экрана
    // Переменные для изменения информации OnBoarding
    private lateinit var onBoardingImg: ImageView
    private lateinit var onBoardingTitle: TextView
    private lateinit var onBoardingDescription: TextView

    // Переменная очереди
    private val onBoardingDeque: ArrayDeque<Map<String, Int>> = ArrayDeque()
    // Переменная для работы с памятью
    private lateinit var appSharedPreferencesHelper: SharedPreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {

        val splashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        // Объявляем хелпер
        appSharedPreferencesHelper = SharedPreferencesHelper(this)

        // Назначаем нашим переменным объекты с макета
        onBoardingImg = findViewById(R.id.onboardingStepImg)
        onBoardingTitle = findViewById(R.id.onboardingStepTitle)
        onBoardingDescription = findViewById(R.id.onboardingStepDescription)

        // Заполняем очередь для onBoarding
        onBoardingDeque.addLast(mapOf(
            "image" to R.drawable.onboarding_img_1,
            "title" to R.string.onboarding_title_1,
            "description" to R.string.onboarding_description_1
        ))
        onBoardingDeque.addLast(mapOf(
            "image" to R.drawable.onboarding_img_2,
            "title" to R.string.onboarding_title_2,
            "description" to R.string.onboarding_description_2
        ))
        onBoardingDeque.addLast(mapOf(
            "image" to R.drawable.onboarding_img_3,
            "title" to R.string.onboarding_title_3,
            "description" to R.string.onboarding_description_3
        ))

        // Отображаем значение из очереди
        updateOnboarding()

        // Назначаем кнопкам кликабельность
        findViewById<LinearLayout>(R.id.nextBtn).setOnClickListener {
            // Вызываем обновление экрана
            updateOnboarding()
        }

        findViewById<LinearLayout>(R.id.skipBtn).setOnClickListener {
            // Удаляем все элементы очереди, кроме последнего
            while (onBoardingDeque.size > 1) onBoardingDeque.removeFirst()

            // Вызываем обновление экрана
            updateOnboarding()
        }
    }

    private fun updateOnboarding() {
        // Смотрим чтобы очередь не была пустной
        if (onBoardingDeque.isNotEmpty()){
            // Достаем первый элемент из очереди и удаляем его
            val stepContent = onBoardingDeque.first()
            onBoardingDeque.removeFirst()

            // Присваиваем контент
            onBoardingImg.setImageResource(stepContent["image"]!!)
            onBoardingTitle.text = getString(stepContent["title"]!!)
            onBoardingDescription.text = getString(stepContent["description"]!!)
        }
        else {
            // Если очередб пустая, то по нажатию на кнопку мы сохраняем статус onBoarding и закрываем его
            appSharedPreferencesHelper.saveData("is_OnBoarding", true)
            finish()
        }
        // Если очередь путсая (то есть последний шаг)
        if (onBoardingDeque.isEmpty()) {
            findViewById<TextView>(R.id.next_btn_text).text = getString(R.string.start_btn_text)
        }
    }
}