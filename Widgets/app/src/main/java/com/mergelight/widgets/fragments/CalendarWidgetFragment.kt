package com.mergelight.widgets.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import androidx.fragment.app.Fragment
import com.mergelight.widgets.R

class CalendarWidgetFragment : Fragment() {

    private lateinit var viewOfFragment: View
    private lateinit var calendarView: CalendarView

    companion object {
        fun newInstance(): CalendarWidgetFragment {
            return CalendarWidgetFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewOfFragment = inflater.inflate(R.layout.fragment_calendar_widget, container, false)
        Log.d("Fragment Button", "onCreateView")

        setupView()
        //setupListenner()

        return viewOfFragment
    }

    private fun setupView(){
        calendarView = viewOfFragment.findViewById(R.id.calendarView)
    }
}