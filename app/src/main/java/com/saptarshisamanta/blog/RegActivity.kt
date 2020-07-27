package com.saptarshisamanta.blog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class RegActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_reg)
//        val navController = this.findNavController(R.id.regNavHostFragment)
//        NavigationUI.setupActionBarWithNavController(this,navController)
    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navController = this.findNavController(R.id.regNavHostFragment)
//        return  navController.navigateUp()
//    }
}