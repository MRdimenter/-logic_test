package com.example.android.logictestproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.android.logictestproject.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentResultBinding>(inflater, R.layout.fragment_result, container, false)
        var args = ResultFragmentArgs.fromBundle(arguments!!) //кол-во правильных ответов


        binding.correctAnswer.text = String.format(getString(R.string.correctAnswer_text), args.correctAnswers) //связывает текст и переменную правильных ответов вместе



        if(args.correctAnswers <= 5) binding.titleAboutResult.setText(R.string.one_test_var)
        else if (args.correctAnswers <= 13) binding.titleAboutResult.setText(R.string.two_test_var)
        else if (args.correctAnswers <= 19) binding.titleAboutResult.setText(R.string.three_test_var)
        else if (args.correctAnswers <= 25) binding.titleAboutResult.setText(R.string.four_test_var)
            else  binding.titleAboutResult.setText(R.string.five_test_var)


        return binding.root



    }
}