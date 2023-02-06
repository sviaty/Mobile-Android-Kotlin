package com.mergelight.viewpager.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mergelight.viewpager.R

class OneFragment : Fragment() {

    private lateinit var viewOfFragment: View
    private lateinit var title: String

    companion object {
        fun newInstance(): OneFragment {
            return OneFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewOfFragment = inflater.inflate(R.layout.fragment_one, container, false)
        Log.d("Fragment one", "onCreateView")

        setupView()
        //setupListenner()

        return viewOfFragment
    }

    private fun setupView(){

    }
}