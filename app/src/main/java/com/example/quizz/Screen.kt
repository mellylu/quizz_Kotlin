package com.example.quizz

sealed class Screen (val itineraire : String){
    object ChoiceQuizz : Screen("ChoiceQuizz")
    object QuestionScreen : Screen("Question")
    object ValidResponse : Screen("ValidResponse")
    object ErrorResponse : Screen("ErrorResponse")
}