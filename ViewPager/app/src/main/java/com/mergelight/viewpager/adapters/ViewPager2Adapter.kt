package com.mergelight.viewpager.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mergelight.viewpager.R
import com.mergelight.viewpager.fragments.OneFragment
import com.mergelight.viewpager.fragments.TwoFragment

class ViewPager2Adapter(activity: FragmentActivity?) : FragmentStateAdapter(activity!!){

    private var listFragment: Array<Fragment> = arrayOf(OneFragment(), TwoFragment())

    override fun getItemCount(): Int {
        return listFragment.size
    }

    override fun createFragment(position: Int): Fragment {
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


}