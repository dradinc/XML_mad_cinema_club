package com.dradinc.kotlinxml_mad_cinemaclub

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class OnBoarding : AppCompatActivity() {
    // Переменные для взаимодействия с объектами экрана
    // Переменные для изменения информации OnBoarding
    private lateinit var onBoardingImg: ImageView
    private lateinit var onBoardingTitle: TextView
    private lateinit var onBoardingDescription: TextView

    // Переменная очереди
    private val onBoardingDeque: ArrayDeque<Map<String, Int>> = ArrayDeque()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

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
    }
}