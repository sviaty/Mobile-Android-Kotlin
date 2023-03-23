package com.mergelight.bottomnavigationview.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.mergelight.bottomnavigationview.R
import com.mergelight.bottomnavigationview.fragments.FirstFragment
import com.mergelight.bottomnavigationview.fragments.SecondFragment

class MainActivity : AppCompatActivity() {

    private lateinit var mNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
        setupFragment()
        setupBottomNavigationView()

    }

    private fun setupView() {
        mNavigation = findViewById(R.id.navigation)
        //mTextView = findViewById(R.id.message)
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

    private fun setupBottomNavigationView(){
        mNavigation.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener {item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    val firstFragment = FirstFragment.newInstance()
                    changeFragment(firstFragment)
                    return@OnItemSelectedListener true
                }
                R.id.navigation_dashboard -> {
                    val secondFragment = SecondFragment.newInstance()
                    changeFragment(secondFragment)
                    return@OnItemSelectedListener true
                }
            }
            false
        })
    }
}