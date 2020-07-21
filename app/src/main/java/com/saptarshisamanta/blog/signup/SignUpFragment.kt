package com.saptarshisamanta.blog.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.saptarshisamanta.blog.R
import com.saptarshisamanta.blog.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment(){
    lateinit var fragmentSignUpBinding: FragmentSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentSignUpBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up,container,false)
        var  view:View = fragmentSignUpBinding.root
        return view
    }
}