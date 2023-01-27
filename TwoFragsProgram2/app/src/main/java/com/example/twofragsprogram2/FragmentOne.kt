package com.example.twofragsprogram2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.twofragsprogram2.databinding.FragmentOneBinding

class FragmentOne : Fragment() {
    private lateinit var binding: FragmentOneBinding
    private lateinit var activityCallBack : FragmentOneListener

    interface FragmentOneListener {
        fun onBtnClick(text : String)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            activityCallBack=activity as FragmentOneListener
        }
        catch (e:java.lang.ClassCastException){
            throw ClassCastException(activity.toString()
                        +"must implement listener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_one, container, false)
        binding.textBtn.setOnClickListener {
            buttonClick()
        }
        return binding.root
    }

    private fun buttonClick() {
       activityCallBack.onBtnClick(binding.textFragOne.text.toString())
    }

}
