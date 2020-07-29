package com.saptarshisamanta.blog.signup

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
import com.saptarshisamanta.blog.data.User
import com.saptarshisamanta.blog.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment(){
    private lateinit var fragmentSignUpBinding: FragmentSignUpBinding
    private lateinit var signUpFragmentViewModel: SignUpFragmentViewModel
    var status:Int=0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentSignUpBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up,container,false)
        signUpFragmentViewModel = ViewModelProvider(this).get(SignUpFragmentViewModel::class.java)
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
            status = signUpFragmentViewModel.signUp(User(email,username,password))
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
                    Toast.makeText(context,"check you network or our server problem",Toast.LENGTH_SHORT).show()
                }
                else -> {
                    //Toast.makeText(getApplication(), "user created", Toast.LENGTH_SHORT).show();
                    Log.d("200", "200")
                    //Intend to next activity
                    requireView().findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToFragmentOtp())
                }
            }

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