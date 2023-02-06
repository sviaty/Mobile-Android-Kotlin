package com.mergelight.viewpager.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.mergelight.viewpager.R
import com.mergelight.viewpager.adapters.ViewPagerAdapter
import com.mergelight.viewpager.adapters.ViewPager2Adapter

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var viewPager2: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var viewPager2Adapter: ViewPager2Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
        setupViewPager()
    }

    private fun setupView(){
        //viewPager = findViewById(R.id.view_pager)
        viewPager2 = findViewById(R.id.view_pager_2)
        tabLayout = findViewById(R.id.tabs)
    }

    private fun setupViewPager(){
        /*
        viewPagerAdapter = ViewPagerAdapter(this, supportFragmentManager)
        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
         */

        viewPager2Adapter = ViewPager2Adapter(this)
        viewPager2.adapter = viewPager2Adapter

        var listTitleFragment: Array<Int> = arrayOf(R.string.tab_text_1, R.string.tab_text_2)

        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = this.resources.getString(listTitleFragment[position])
        }.attach()
    }
}