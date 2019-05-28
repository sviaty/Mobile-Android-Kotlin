package com.example.spkc6448.recyclerview.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.spkc6448.recyclerview.R
import com.example.spkc6448.recyclerview.adapters.MainRecyclerViewAdapter

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

