package com.example.spkc6448.recyclerview.adapters

import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.spkc6448.recyclerview.R

class MainRecyclerViewAdapter(val dataList : List<String>) : RecyclerView.Adapter<MainRecyclerViewAdapter.MainRecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainRecyclerViewAdapter.MainRecyclerViewHolder {
        // To change body of created functions use File | Settings | File Templates.
        val view : View = LayoutInflater.from(parent!!.context).inflate(R.layout.items_main_data, parent, false)
        return MainRecyclerViewAdapter.MainRecyclerViewHolder(view)
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

    class MainRecyclerViewHolder: RecyclerView.ViewHolder {
        lateinit var tvMainData : TextView
        constructor(itemView: View) : super(itemView) {
            tvMainData = itemView.findViewById(R.id.tv_main_data_text)
        }
    }
}

