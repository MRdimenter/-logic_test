package com.example.android.logictestproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.logictestproject.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater, R.layout.fragment_title, container, false)
        
        binding.startButton.setOnClickListener { v: View ->  v.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)} //listener для перехода на другой фрагмент

        binding.InstructionButton.setOnClickListener { v: View -> v.findNavController().navigate(R.id.action_titleFragment_to_instructionFragment)  }
        return binding.root
        
        

    }
}