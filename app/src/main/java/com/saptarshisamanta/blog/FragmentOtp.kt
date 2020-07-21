package com.saptarshisamanta.blog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.saptarshisamanta.blog.databinding.FragmentOtpBinding

class FragmentOtp : Fragment(){
    lateinit var fragmentOtpBinding: FragmentOtpBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentOtpBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_otp,container,false)
        var view:View = fragmentOtpBinding.root
        return  view
    }
}