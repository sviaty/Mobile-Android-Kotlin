package com.mergelight.widgets.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.mergelight.widgets.R
import com.mergelight.widgets.adapters.ViewPagerAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
        setupViewPager()
    }

    private fun setupView(){
        viewPager = findViewById(R.id.view_pager)
        tabLayout = findViewById(R.id.tabs)
    }

    private fun setupViewPager(){
        viewPagerAdapter = ViewPagerAdapter(this, supportFragmentManager)
        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }
}