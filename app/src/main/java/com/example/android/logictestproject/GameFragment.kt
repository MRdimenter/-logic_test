package com.example.android.logictestproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.logictestproject.databinding.FragmentGameBinding


class GameFragment : Fragment() {

    var model = Model()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(inflater, R.layout.fragment_game, container, false)
        binding.game = model


        model.setQuestion()
        var count: Int = 0
        binding.submitButton.setOnClickListener { v: View ->
                val checkedId = binding.questionRadioGroup.checkedRadioButtonId
                if (-1 != checkedId) {
                    if (count <= 9) {
                    var answerIndex = 0 //выбор игрока
                    when (checkedId) {
                        R.id.secondAnswerRadioButton -> answerIndex = 1
                        R.id.thirdAnswerRadioButton -> answerIndex = 2
                    }
                    //первый ответ в ихсодном вопросе всегда правильный, поэтому если наш ответ совпадает, у нас правильный ответ
                    if (model.answers[answerIndex] == model.currentQuestion.answers[0]) {
                        model.correctAnswer++
                        println(model.correctAnswer)
                        // Переход к следующему вопросу
                    }
                    model.questionIndex++
                    model.currentQuestion = model.questions[model.questionIndex]
                    model.setQuestion()

                    binding.questionRadioGroup.clearCheck()
                    binding.invalidateAll()
                    count++
                    }else  v.findNavController().navigate(GameFragmentDirections.actionGameFragmentToResultFragment(model.correctAnswer))
                }
        }
        return binding.root
    }
}