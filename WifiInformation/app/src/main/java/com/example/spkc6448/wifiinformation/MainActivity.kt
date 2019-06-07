package com.example.spkc6448.wifiinformation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.spkc6448.wifiinformation.internetManager.NetworkManager
import com.example.spkc6448.wifiinformation.internetManager.WifiScanManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wifiScanManager = WifiScanManager(this)
        val networkManager = NetworkManager(this)

        val connectInfo = wifiScanManager.getWifiConnectionInfo()
        val networkInfo = networkManager.getNetworkInfo()
    }
}
