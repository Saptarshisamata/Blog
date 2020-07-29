package com.saptarshisamanta.blog.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.saptarshisamanta.blog.R
import com.saptarshisamanta.blog.databinding.FragmentLogInBinding

class LogInFragment : Fragment(){
    private lateinit var fragmentLogInBinding: FragmentLogInBinding
    private lateinit var logInFragmentViewModel:LogInFragmentViewModel
    private var status:Int =0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentLogInBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_log_in,container,false)

        logInFragmentViewModel = ViewModelProvider(this).get(LogInFragmentViewModel::class.java)
        fragmentLogInBinding.login.setOnClickListener {
            login()
            //Navigation.findNavController(view).navigate(R.id.action_logInFragment_to_fragmentOtp)
            //view?.findNavController()?.navigate(LogInFragmentDirections.actionLogInFragmentToFragmentOtp())
            //Navigation.createNavigateOnClickListener(R.id.action_logInFragment_to_fragmentOtp)
        }
        fragmentLogInBinding.signuppage.setOnClickListener { view: View ->
            view.findNavController().navigate(LogInFragmentDirections.actionLogInFragmentToSignUpFragment())
        }
        return  fragmentLogInBinding.root
    }
    private fun login(){
        val email:String = fragmentLogInBinding.emailTextLayout.editText!!.text.toString().trim()
        val password:String = fragmentLogInBinding.passwordLayout.editText!!.text.toString().trim()

        if (!(validateEmail(email) || validatePassword(password))){
            return
        }else{
            val parameter:HashMap<String,String> = HashMap()
            parameter["email"] = email
            parameter["password"] = password
            // TODO(01) login api handling
            logInFragmentViewModel.logIn(parameter)
            when (status) {
                400 -> {
                    Toast.makeText(context, "check your details", Toast.LENGTH_SHORT).show()
                    Log.d("400", "400")
                }
                412 -> {
                    Toast.makeText(context, "user already exist", Toast.LENGTH_SHORT).show()
                    Log.d("400", "400")
                }
                500 -> {
                    Toast.makeText(context, "Internal server error", Toast.LENGTH_SHORT).show()
                    Log.d("400", "400")
                }
                404 -> {
                    Toast.makeText(context, "not found", Toast.LENGTH_SHORT).show()
                    Log.d("400", "400")
                }
                1001 -> {
                    Toast.makeText(context,"check you network or our server problem", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    //Toast.makeText(getApplication(), "user created", Toast.LENGTH_SHORT).show();
                    Log.d("200", "200")
                    //Intend to next activity
                    requireView().findNavController().navigate(LogInFragmentDirections.actionLogInFragmentToFragmentOtp())
                }
            }
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
            fragmentLogInBinding.passwordLayout.error = "Password Required"
            false
        }else{
            fragmentLogInBinding.passwordLayout.error = null
            true
        }
    }
}