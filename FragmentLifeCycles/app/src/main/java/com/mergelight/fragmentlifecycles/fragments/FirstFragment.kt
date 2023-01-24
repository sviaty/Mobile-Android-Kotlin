package com.mergelight.fragmentlifecycles.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.mergelight.fragmentlifecycles.R
import com.mergelight.fragmentlifecycles.activities.MainActivity
import com.mergelight.fragmentlifecycles.constants.Constants

class FirstFragment : Fragment() {

    private lateinit var viewOfFragment: View
    private lateinit var mBtnGoToSecondFrgmt: Button

    companion object {
        fun newInstance(): FirstFragment {
            return FirstFragment()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("Fragment life cycle 1", "onAttach")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewOfFragment = inflater.inflate(R.layout.fragment_first, container, false)
        Log.d("Fragment life cycle 1", "onCreateView")

        setupView()
        setupListenner()

        return viewOfFragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Fragment life cycle 1", "onViewCreated")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("Fragment life cycle 1", "onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Fragment life cycle 1", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Fragment life cycle 1", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Fragment life cycle 1", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Fragment life cycle 1", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("Fragment life cycle 1", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Fragment life cycle 1", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("Fragment life cycle 1", "onDetach")
    }

    private fun setupView(){
        mBtnGoToSecondFrgmt = viewOfFragment.findViewById(R.id.btn_go_to_second_frgmt)
    }

    private fun setupListenner(){
        mBtnGoToSecondFrgmt.setOnClickListener {
            goToSecondFragment()
        }
    }

    private fun goToSecondFragment(){
        Log.d("Fragment life cycle 1", "Go to second fragment")

        val bundle = Bundle()
        bundle.putString(Constants.KEYS_DATA_BUNDLE, "test passing datas beetwin two fragments")

        val secondFrgmt = SecondFragment.newInstance()
        secondFrgmt.arguments = bundle

        val activity = this.activity as MainActivity
        activity.changeFragment(secondFrgmt)
    }
}