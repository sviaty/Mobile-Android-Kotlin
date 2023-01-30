package com.mergelight.fragmentlifecycles.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.mergelight.fragmentlifecycles.R
import com.mergelight.fragmentlifecycles.fragments.FirstFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupFragment()
    }

    // load fragment in activity
    private fun setupFragment(){
        val firstFragment = FirstFragment.newInstance()
        changeFragment(firstFragment)
    }

    // update fragment in activity
    fun changeFragment(frgmt: Fragment){
        val fragmentManager: FragmentManager = this.supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frgmt_fragment, frgmt)
        fragmentTransaction.commit()
    }
}
