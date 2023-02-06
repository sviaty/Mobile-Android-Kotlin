package com.mergelight.widgets.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.mergelight.widgets.R
import com.mergelight.widgets.fragments.ButtonFragment
import com.mergelight.widgets.fragments.EditTextFragment

class ViewPagerAdapter(private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private var listFragment: Array<Fragment> = arrayOf(EditTextFragment(), ButtonFragment())
    private var listTitleFragment: Array<Int> = arrayOf(R.string.tab_text_1, R.string.tab_text_2)

    override fun getCount(): Int {
        return listFragment.size
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> {
                EditTextFragment.newInstance()
            }
            1 -> {
                ButtonFragment.newInstance()
            }
            else -> {
                EditTextFragment.newInstance()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(listTitleFragment[position])
    }

}