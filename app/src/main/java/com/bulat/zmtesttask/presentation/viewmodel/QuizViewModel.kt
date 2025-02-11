package com.bulat.zmtesttask.presentation.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor() : ViewModel() {
    private val questions = listOf(
        Question(
            "What is the maximum weight of a salmon?",
            listOf("20 kg", "40 kg", "60 kg"),
            correctAnswer = 1
        ),
        Question(
            "Where do salmon migrate to spawn?",
            listOf("Lakes", "Rivers", "Oceans"),
            correctAnswer = 1
        ),
        Question(
            "What is the maximum length of a salmon?",
            listOf("100 cm", "150 cm", "200 cm"),
            correctAnswer = 1
        )
    )

    data class Question(
        val text: String,
        val answers: List<String>,
        val correctAnswer: Int
    )
} 