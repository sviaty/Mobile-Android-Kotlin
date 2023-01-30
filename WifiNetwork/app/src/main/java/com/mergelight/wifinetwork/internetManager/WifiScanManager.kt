package com.mergelight.wifinetwork.internetManager

import android.content.Context
import android.net.DhcpInfo
import android.net.wifi.WifiManager
import android.net.wifi.WifiInfo

class WifiScanManager(context: Context) {

    private var mWifiManager: WifiManager
    var mContext: Context = context

    init {
        mWifiManager = mContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
    }

    fun isWifiEnable() {
        if (!mWifiManager.isWifiEnabled) {
            mWifiManager.isWifiEnabled = true
        }
    }

    fun isWifiDisable() {
        if (mWifiManager.isWifiEnabled) {
            mWifiManager.isWifiEnabled = false
        }
    }

    fun getWifiConnectionInfo(): WifiInfo {
        return mWifiManager.connectionInfo
    }

    fun getWifiDhcpInfo(): DhcpInfo {
        return mWifiManager.dhcpInfo
    }

    fun getWifiState(): Int {
        return mWifiManager.wifiState
    }
}