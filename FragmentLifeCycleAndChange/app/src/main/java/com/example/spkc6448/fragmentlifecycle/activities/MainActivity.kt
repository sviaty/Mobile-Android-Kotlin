package com.example.spkc6448.fragmentlifecycle.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.example.spkc6448.fragmentlifecycle.R
import com.example.spkc6448.fragmentlifecycle.fragments.FirstFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupFragment()
    }

    // fonction qui charge le premier fragment dans l'activity
    private fun setupFragment(){
        val firstFragment = FirstFragment.newInstance()
        changeFragment(firstFragment)
    }

    // fonction qui permet le changement de fragment dynamiquement dans l'activity
    fun changeFragment(frgmt: Fragment){
        val fragmentManager: FragmentManager = this.supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frgmt_fragment, frgmt)
        fragmentTransaction.commit()
    }
}
