package com.mergelight.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder




class MainRecyclerViewAdapter(val dataList : List<String>) : RecyclerView.Adapter<MainRecyclerViewAdapter.MainRecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRecyclerViewHolder {
        val context: Context = parent.context
        val inflater = LayoutInflater.from(context)

        val view: View = inflater.inflate(R.layout.items_main_data, parent, false)

        return MainRecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        //To change body of created functions use File | Settings | File Templates.
        return dataList.size
    }

    override fun onBindViewHolder(holder: MainRecyclerViewAdapter.MainRecyclerViewHolder, position: Int) {
        //To change body of created functions use File | Settings | File Templates.
        val data : String = dataList[position]
        holder.tvMainData.text = data
    }

    class MainRecyclerViewHolder: ViewHolder {
        var tvMainData : TextView
        constructor(itemView: View) : super(itemView) {
            tvMainData = itemView.findViewById(R.id.tv_main_data_text)
        }
    }
}

