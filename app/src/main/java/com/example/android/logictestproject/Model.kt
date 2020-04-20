package com.example.android.logictestproject

class Model {

    val questions = Data().questions
    lateinit var currentQuestion: Data.Question //текущий вопрос
    lateinit var answers: MutableList<String> //ответы
    var questionIndex = 0 //индекс вопроса
    val numQuestions = Math.min((questions.size + 1) / 2, 3)
    var correctAnswer = 0 //правильные ответы


    //устанавливает вопрос и рандомизирует ответы, меняет данные, а не пользовательский интерфейс
    fun setQuestion() {
        currentQuestion = questions[questionIndex]
        // randomize the answers into a copy of the array
        answers = currentQuestion.answers.toMutableList()
        // and shuffle them
        answers.shuffle()

    }


    //визуализация числа вопросов
    fun setTitleQuestion(): String {
        var index = questionIndex;
        Integer.toString(index++)
        return "Вопрос $index / ${questions.size}"
    }
}