package com.mergelight.widgets.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mergelight.widgets.R

class ProgressWidgetFragment : Fragment() {

    private lateinit var viewOfFragment: View

    companion object {
        fun newInstance(): ProgressWidgetFragment {
            return ProgressWidgetFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewOfFragment = inflater.inflate(R.layout.fragment_progress_widget, container, false)
        Log.d("Fragment Button", "onCreateView")

        setupView()
        //setupListenner()

        return viewOfFragment
    }

    private fun setupView(){

    }
}