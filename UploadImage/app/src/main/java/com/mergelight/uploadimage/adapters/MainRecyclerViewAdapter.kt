package com.mergelight.uploadimage.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.mergelight.uploadimage.R
import com.mergelight.uploadimage.constants.Constants
import com.mergelight.uploadimage.models.UploadsImages

class MainRecyclerViewAdapter(val dataList : Array<UploadsImages>) : RecyclerView.Adapter<MainRecyclerViewAdapter.MainRecyclerViewHolder>() {

    lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRecyclerViewHolder {
        mContext = parent.context
        val inflater = LayoutInflater.from(mContext)

        val view: View = inflater.inflate(R.layout.items_main_data, parent, false)

        return MainRecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        //To change body of created functions use File | Settings | File Templates.
        return dataList.size
    }

    override fun onBindViewHolder(holder: MainRecyclerViewAdapter.MainRecyclerViewHolder, position: Int) {
        //To change body of created functions use File | Settings | File Templates.
        val data : UploadsImages = dataList[position]
        holder.tvMainData.text = data.imgUrl
        //holder.ivUpload.setImageResource(R.drawable.ic_launcher_foreground)

        Glide.with(mContext)
            .load(Constants.BASE_URL_IMG+data.imgUrl)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.ivUpload)

    }

    class MainRecyclerViewHolder: ViewHolder {
        var tvMainData : TextView
        var ivUpload : ImageView
        constructor(itemView: View) : super(itemView) {
            tvMainData = itemView.findViewById(R.id.tv_main_data_text)
            ivUpload = itemView.findViewById(R.id.image_view)
        }
    }
}

