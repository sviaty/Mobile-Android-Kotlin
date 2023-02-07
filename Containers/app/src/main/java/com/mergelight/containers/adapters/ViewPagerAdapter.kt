package com.mergelight.containers.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mergelight.containers.fragments.ConstraintLayoutFragment
import com.mergelight.containers.fragments.GridLayoutFragment
import com.mergelight.containers.fragments.LinearLayoutFragment
import com.mergelight.containers.fragments.RelativeLayoutFragment

class ViewPager2Adapter(activity: FragmentActivity?) : FragmentStateAdapter(activity!!){

    private var listFragment: Array<Fragment> = arrayOf(
        LinearLayoutFragment(),
        RelativeLayoutFragment(),
        ConstraintLayoutFragment(),
        GridLayoutFragment()
    )

    override fun getItemCount(): Int {
        return listFragment.size
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> {
                LinearLayoutFragment.newInstance()
            }
            1 -> {
                RelativeLayoutFragment.newInstance()
            }
            2 -> {
                ConstraintLayoutFragment.newInstance()
            }
            3 -> {
                GridLayoutFragment.newInstance()
            }
            else -> {
                LinearLayoutFragment.newInstance()
            }
        }
    }


}