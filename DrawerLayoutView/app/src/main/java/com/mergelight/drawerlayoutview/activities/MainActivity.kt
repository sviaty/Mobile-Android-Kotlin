package com.mergelight.drawerlayoutview.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.navigation.NavigationView
import com.mergelight.drawerlayoutview.R
import com.mergelight.fragmentlifecycles.fragments.FirstFragment
import com.mergelight.fragmentlifecycles.fragments.SecondFragment

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var mToolbar: Toolbar
    private lateinit var mToggle: ActionBarDrawerToggle
    private lateinit var mNavigationView: NavigationView
    private lateinit var mDrawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()

        setSupportActionBar(mToolbar)
        setupFragment()
        setupDrawerNavigationView()
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        mToggle.syncState()
    }

    // change fragment from drawer menu
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_fragment_one -> {
                mDrawerLayout.close()
                val firstFragment = FirstFragment.newInstance()
                changeFragment(firstFragment)
                Toast.makeText(this, "Fragment one", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_fragment_two -> {
                mDrawerLayout.close()
                val secondFragment = SecondFragment.newInstance()
                changeFragment(secondFragment)
                Toast.makeText(this, "Fragment two", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }

    private fun setupView() {
        mToolbar = findViewById(R.id.toolbar)
        mDrawerLayout = findViewById(R.id.drawer_layout)
        mNavigationView = findViewById(R.id.nav_view)
    }

    private fun setupDrawerNavigationView() {

        mToggle = ActionBarDrawerToggle(
            this,
            mDrawerLayout,
            mToolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close)

        mDrawerLayout.addDrawerListener(mToggle)
        mNavigationView.setNavigationItemSelectedListener(this)
    }

    // load fragment in activity
    private fun setupFragment(){
        val firstFragment = FirstFragment.newInstance()
        changeFragment(firstFragment)
    }

    // change fragment in activity
    fun changeFragment(frgmt: Fragment){
        val fragmentManager: FragmentManager = this.supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_content_main, frgmt)
        fragmentTransaction.commit()
    }
}