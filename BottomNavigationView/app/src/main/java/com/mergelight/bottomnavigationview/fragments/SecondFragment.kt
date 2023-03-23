package com.mergelight.bottomnavigationview.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mergelight.bottomnavigationview.R
import com.mergelight.bottomnavigationview.activities.MainActivity
import com.mergelight.bottomnavigationview.constants.Constants

class SecondFragment : Fragment() {

    private lateinit var viewOfFragment: View

    var valueBundle: String? = null

    companion object {
        fun newInstance(): SecondFragment {
            return SecondFragment()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("Fragment life cycle 2", "onAttach")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewOfFragment = inflater.inflate(R.layout.fragment_second, container, false)
        Log.d("Fragment life cycle 2", "onCreateView")

        loadDataBundle()
        setupView()
        setupListenner()

        return viewOfFragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Fragment life cycle 2", "onViewCreated")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("Fragment life cycle 2", "onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Fragment life cycle 2", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Fragment life cycle 2", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Fragment life cycle 2", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Fragment life cycle 2", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("Fragment life cycle 2", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Fragment life cycle 2", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("Fragment life cycle 2", "onDetach")
    }

    private fun loadDataBundle(){
        if(arguments != null){
            valueBundle = arguments?.getString(Constants.KEYS_DATA_BUNDLE)
            Toast.makeText(this.activity?.applicationContext, valueBundle , Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupView(){

    }

    private fun setupListenner(){

    }

}