package com.mergelight.widgets.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mergelight.widgets.R

class EditTextFragment : Fragment() {

    private lateinit var viewOfFragment: View
    private lateinit var title: String

    companion object {
        fun newInstance(): EditTextFragment {
            return EditTextFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewOfFragment = inflater.inflate(R.layout.fragment_edit_text, container, false)
        Log.d("Fragment Edit Text", "onCreateView")

        setupView()
        //setupListenner()

        return viewOfFragment
    }

    private fun setupView(){

    }
}