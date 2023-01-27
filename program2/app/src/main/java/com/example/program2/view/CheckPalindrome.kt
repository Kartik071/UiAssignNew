package com.example.program2.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.program2.R
import com.example.program2.databinding.FragmentCheckPalindromeBinding
import com.google.android.material.snackbar.Snackbar


class CheckPalindrome : Fragment() {
    private lateinit var binding: FragmentCheckPalindromeBinding

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_check_palindrome,
            container,
            false
        )
        binding.btn.setOnClickListener {
            val number = binding.edtCheck.text.toString()
            Log.d("Android", "onCreateView: $number")
            if (!binding.edtCheck.text.isNullOrEmpty()) {
                if (checkPalindrome(number)) {
                    binding.textView.text = "Palindrome"
                } else {
                    binding.textView.text = addValues(number)
                }

            }
            Snackbar.make(binding.root, "Enter a valid number", Snackbar.LENGTH_LONG).show()
        }

        return binding.root
    }

    private fun addValues(number: String): String {
        var num = number.toInt()
        var newSum = 0
        while (num != 0) {
            newSum += num % 10
            num /= 10
        }
        return newSum.toString()

    }

    private fun checkPalindrome(number: String): Boolean {
        var reverseN = ""
        val length = number.length

        for (i in (length - 1) downTo 0) {
            reverseN += number[i]
        }
        return number == reverseN
    }


}