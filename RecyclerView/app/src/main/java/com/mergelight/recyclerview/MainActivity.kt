package com.mergelight.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var rvData: RecyclerView
    lateinit var dataList: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvData = findViewById(R.id.rv_data)
        dataList = listOf("Android","iOS","Windobe")

        rvData.layoutManager = LinearLayoutManager(this)
        rvData.adapter =  MainRecyclerViewAdapter(dataList)
    }
}