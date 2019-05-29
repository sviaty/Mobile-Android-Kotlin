package com.example.spkc6448.fragmentlifecycle.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.spkc6448.fragmentlifecycle.R
import com.example.spkc6448.fragmentlifecycle.activities.MainActivity
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment() {

    companion object {
        fun newInstance(): SecondFragment {
            return SecondFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)

        setupListenner()
    }

    private fun setupListenner(){
        btn_go_to_first_frgmt.setOnClickListener {
            goToFirstFragment()
        }
    }

    private fun goToFirstFragment(){
        val firstFrgmt = FirstFragment.newInstance()
        val activity = this.activity as MainActivity
        activity.changeFragment(firstFrgmt)
    }
}