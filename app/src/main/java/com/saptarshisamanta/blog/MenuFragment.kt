package com.saptarshisamanta.blog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.saptarshisamanta.blog.databinding.FragmentMenuBinding

class MenuFragment : Fragment(){
    lateinit var fragmentMenuBinding: FragmentMenuBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentMenuBinding = FragmentMenuBinding.inflate(inflater,container,false)
        return fragmentMenuBinding.root
    }
}