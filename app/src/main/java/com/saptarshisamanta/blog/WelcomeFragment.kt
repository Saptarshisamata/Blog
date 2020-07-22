package com.saptarshisamanta.blog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.saptarshisamanta.blog.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment(){
    private lateinit var fragmentWelcomeBinding: FragmentWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentWelcomeBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_welcome,container,false)
        fragmentWelcomeBinding.next.setOnClickListener{view:View ->
            view.findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToLogInFragment())
        }
        return fragmentWelcomeBinding.root
    }
}