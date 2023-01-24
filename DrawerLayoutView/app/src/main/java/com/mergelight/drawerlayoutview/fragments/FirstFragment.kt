package com.mergelight.fragmentlifecycles.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.mergelight.drawerlayoutview.R
import com.mergelight.drawerlayoutview.activities.MainActivity

class FirstFragment : Fragment() {

    private lateinit var viewOfFragment: View

    companion object {
        fun newInstance(): FirstFragment {
            return FirstFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewOfFragment = inflater.inflate(R.layout.fragment_first, container, false)
        //Log.d("Fragment life cycle", "onCreateView")

        return viewOfFragment
    }
}