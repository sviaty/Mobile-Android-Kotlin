package com.mergelight.wifinetwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import com.mergelight.wifinetwork.internetManager.NetworkManager
import com.mergelight.wifinetwork.internetManager.WifiScanManager

class MainActivity : AppCompatActivity() {

    private lateinit var lvWifiInfo: ListView
    private lateinit var BtnWifiScan: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
        setupListenner()

        val wifiScanManager = WifiScanManager(this)
        val networkManager = NetworkManager(this)

        val connectInfo = wifiScanManager.getWifiConnectionInfo()
        val networkInfo = networkManager.getNetworkInfo()
    }

    private fun setupView(){
        lvWifiInfo = findViewById(R.id.lv_wifiList)
        BtnWifiScan = findViewById(R.id.btn_scan)
    }

    private fun setupListenner(){
        BtnWifiScan.setOnClickListener {

        }
    }
}