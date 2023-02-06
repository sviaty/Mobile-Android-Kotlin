package com.mergelight.viewpager.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.mergelight.viewpager.R
import com.mergelight.viewpager.fragments.OneFragment
import com.mergelight.viewpager.fragments.TwoFragment

class ViewPagerAdapter(private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private var listFragment: Array<Fragment> = arrayOf(OneFragment(), TwoFragment())
    private var listTitleFragment: Array<Int> = arrayOf(R.string.tab_text_1, R.string.tab_text_2)

    override fun getCount(): Int {
        return listFragment.size
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> {
                OneFragment.newInstance()
            }
            1 -> {
                TwoFragment.newInstance()
            }
            else -> {
                OneFragment.newInstance()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(listTitleFragment[position])
    }

}