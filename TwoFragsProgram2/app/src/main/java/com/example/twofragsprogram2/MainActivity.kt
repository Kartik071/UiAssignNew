package com.example.twofragsprogram2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.example.twofragsprogram2.databinding.ActivityMainBinding

class MainActivity : FragmentActivity(), FragmentOne.FragmentOneListener{
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)

    }


    override fun onBtnClick(text: String) {
       val textFragment: FragmentTwo = supportFragmentManager.findFragmentById(R.id.fragmentTwo) as FragmentTwo
        textFragment.changeText(text)
    }
}