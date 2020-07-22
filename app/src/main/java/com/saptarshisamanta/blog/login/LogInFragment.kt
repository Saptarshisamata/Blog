package com.saptarshisamanta.blog.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.saptarshisamanta.blog.R
import com.saptarshisamanta.blog.databinding.FragmentLogInBinding

class LogInFragment : Fragment(){
    private lateinit var fragmentLogInBinding: FragmentLogInBinding
    private lateinit var logInFragmentViewModel:LogInFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentLogInBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_log_in,container,false)

        logInFragmentViewModel = ViewModelProvider(this).get(LogInFragmentViewModel::class.java)
        fragmentLogInBinding.login.setOnClickListener {view:View?->
            login()
            //Navigation.findNavController(view).navigate(R.id.action_logInFragment_to_fragmentOtp)
            view?.findNavController()?.navigate(LogInFragmentDirections.actionLogInFragmentToFragmentOtp())
            //Navigation.createNavigateOnClickListener(R.id.action_logInFragment_to_fragmentOtp)
        }
        fragmentLogInBinding.signuppage.setOnClickListener { view: View? ->
            view?.findNavController()?.navigate(LogInFragmentDirections.actionLogInFragmentToSignUpFragment())
        }
        return  fragmentLogInBinding.root
    }
    private fun login(){
        val email:String = fragmentLogInBinding.emailTextLayout.editText!!.text.toString().trim()
        val password:String = fragmentLogInBinding.passwordLayout.editText!!.text.toString().trim()

        if (validateEmail(email) && validatePassword(password)){
            var parameter:HashMap<String,String> = HashMap()
            parameter["email"] = email
            parameter["password"] = password
            // TODO(01) login api handling
        }
    }
    private fun validateEmail(email:String) : Boolean {
        return if (email.isEmpty()){
            fragmentLogInBinding.emailTextLayout.error = "E-Mail Required"
            false
        }else{
            fragmentLogInBinding.emailTextLayout.error = null
            true
        }
    }
    private fun validatePassword(password:String) : Boolean {
        return if (password.isEmpty()){
            fragmentLogInBinding.emailTextLayout.error = "Password Required"
            false
        }else{
            fragmentLogInBinding.emailTextLayout.error = null
            true
        }
    }
}