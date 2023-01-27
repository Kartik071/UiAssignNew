package com.example.twofragsprogram2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.twofragsprogram2.databinding.FragmentTwoBinding


class FragmentTwo : Fragment() {
    private lateinit var binding : FragmentTwoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(layoutInflater,R.layout.fragment_two,container,false)


        return binding.root
    }

     fun changeText(text : String) {
        binding.changedText.text = text
    }

}
