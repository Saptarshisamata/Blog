package com.saptarshisamanta.blog.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.saptarshisamanta.blog.R
import com.saptarshisamanta.blog.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment(){
    private lateinit var fragmentSignUpBinding: FragmentSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentSignUpBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up,container,false)
        fragmentSignUpBinding.signUp.setOnClickListener {
            signUp()
        }
        return fragmentSignUpBinding.root
    }

    private fun signUp(){
        val email:String = fragmentSignUpBinding.emailTextLayout.editText!!.text.toString().trim()
        val password:String = fragmentSignUpBinding.passwordLayout.editText!!.text.toString().trim()
        val username:String = fragmentSignUpBinding.userLayout.editText!!.text.toString().trim()

        if (!(validateEmail(email) || validatePassword(password) || username.isNotEmpty())){
            return
        }else{
            // TODO(2) signUp api handle
            requireView().findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToFragmentOtp())
        }
    }
    private fun validateEmail(email:String) : Boolean {
        return if (email.isEmpty()){
            fragmentSignUpBinding.emailTextLayout.error = "E-Mail Required"
            false
        }else{
            fragmentSignUpBinding.emailTextLayout.error = null
            true
        }
    }
    private fun validatePassword(password:String) : Boolean {
        return if (password.isEmpty()){
            fragmentSignUpBinding.passwordLayout.error = "Password Required"
            false
        }else{
            fragmentSignUpBinding.passwordLayout.error = null
            true
        }
    }
}