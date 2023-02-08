package com.mergelight.containers.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mergelight.containers.R

class FrameLayoutFragment : Fragment() {

    private lateinit var viewOfFragment: View

    companion object {
        fun newInstance(): FrameLayoutFragment {
            return FrameLayoutFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewOfFragment = inflater.inflate(R.layout.fragment_frame_layout, container, false)
        Log.d("Fragment ConstraintLayout", "onCreateView")

        setupView()
        //setupListenner()

        return viewOfFragment
    }

    private fun setupView(){

    }
}