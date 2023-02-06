package com.mergelight.viewpager.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mergelight.viewpager.R

class TwoFragment : Fragment() {

    private lateinit var viewOfFragment: View

    companion object {
        fun newInstance(): TwoFragment {
            return TwoFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewOfFragment = inflater.inflate(R.layout.fragment_two, container, false)
        Log.d("Fragment two", "onCreateView")

        setupView()
        //setupListenner()

        return viewOfFragment
    }

    private fun setupView(){

    }
}