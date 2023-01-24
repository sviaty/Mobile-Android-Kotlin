package com.mergelight.bottomnavigationview

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView


class MainActivity : AppCompatActivity() {

    private lateinit var mNavigation: BottomNavigationView
    private lateinit var mTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
        setupBottomNavigationView()

    }

    private fun setupView() {
        mNavigation = findViewById(R.id.navigation)
        mTextView = findViewById(R.id.message)
    }

    private fun setupBottomNavigationView(){
        mNavigation.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener {item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    mTextView.setText(R.string.title_home)
                    return@OnItemSelectedListener true
                }
                R.id.navigation_dashboard -> {
                    mTextView.setText(R.string.title_dashboard)
                    return@OnItemSelectedListener true
                }
                R.id.navigation_notifications -> {
                    mTextView.setText(R.string.title_notifications)
                    return@OnItemSelectedListener true
                }
            }
            false
        })
    }
}