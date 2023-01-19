package com.example.uiassign

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.uiassign.databinding.FragmentRegisterBinding
import com.google.android.material.snackbar.Snackbar
import java.util.regex.Pattern

class RegisterFragment : Fragment() {
    private lateinit var bindingRegister: FragmentRegisterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        bindingRegister =
            DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)
        clickHandle()

        bindingRegister.TermsAndCondition.setOnClickListener {
            openTermsFrag()
        }
        return bindingRegister.root
    }

    private fun clickHandle() {
        bindingRegister.registerButton.setOnClickListener {
            if (checkEmpty()) {
                if (checkSamePass()) {
                    if (isChecked()) {
                        if (validate(bindingRegister.email.text.toString().trim())) {
                            // Toast.makeText(requireActivity(),"Successful Login ",Toast.LENGTH_LONG).show()
                            Snackbar.make(
                                bindingRegister.root,
                                "Successful Login",
                                Snackbar.LENGTH_LONG
                            ).show()
                            openFrag()
                        } else
                            Snackbar.make(
                                bindingRegister.root,
                                "Enter A Valid Email",
                                Snackbar.LENGTH_LONG
                            ).show()
                    } else
                        Snackbar.make(
                            bindingRegister.root,
                            "Please Accept Terms And Conditions",
                            Snackbar.LENGTH_LONG
                        ).show()
                } else
                    Snackbar.make(
                        bindingRegister.root,
                        "Password Do Not Match",
                        Snackbar.LENGTH_LONG
                    ).show()

            }
        }
        bindingRegister.loginPageBtn.setOnClickListener {
            openFrag()
        }

    }

    private fun openFrag() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, LoginFragment()).addToBackStack("").commit()
    }

    private fun openTermsFrag() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, TermsAndCondition()).addToBackStack("").commit()

    }

    private fun checkEmpty(): Boolean {
        if (bindingRegister.Name.text.isNullOrEmpty()) {
            bindingRegister.Name.error = "Field Required"
            return false
        }
        if (bindingRegister.email.text.isNullOrEmpty()) {
            bindingRegister.email.error = "Field Required"
            return false
        }
        if (bindingRegister.password.text.isNullOrEmpty()) {
            bindingRegister.password.error = "Field Required"
            return false
        }
        if (bindingRegister.passRetype.text.isNullOrEmpty()) {
            bindingRegister.passRetype.error = "Field Required"
            return false
        }
        return true
    }

    private fun validate(email: String): Boolean {

        return Pattern.compile(
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        ).matcher(email).matches()


    }

    private fun checkSamePass(): Boolean {
        return bindingRegister.password.text.toString() == bindingRegister.passRetype.text.toString()
    }

    private fun isChecked(): Boolean {
        return bindingRegister.checkbox.isChecked
    }



}