package com.mergelight.widgets.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mergelight.widgets.fragments.*

class ViewPager2Adapter(activity: FragmentActivity?) : FragmentStateAdapter(activity!!){

    private var listFragment: Array<Fragment> = arrayOf(
        TextWidgetFragment(),
        ButtonWidgetFragment(),
        ProgressWidgetFragment(),
        MediaWidgetFragment(),
        WebViewWidgetFragment(),
        CalendarWidgetFragment()
    )

    override fun getItemCount(): Int {
        return listFragment.size
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> {
                TextWidgetFragment.newInstance()
            }
            1 -> {
                ButtonWidgetFragment.newInstance()
            }
            2 -> {
                ProgressWidgetFragment.newInstance()
            }
            3 -> {
                MediaWidgetFragment.newInstance()
            }
            4 -> {
                WebViewWidgetFragment.newInstance()
            }
            5 -> {
                CalendarWidgetFragment.newInstance()
            }
            else -> {
                TextWidgetFragment.newInstance()
            }
        }
    }


}