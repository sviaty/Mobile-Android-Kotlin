package com.mergelight.wifinetwork.internetManager

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities


class NetworkManager(context: Context) {

    var mContext: Context = context
    var mConnectivityManager: ConnectivityManager?

    init {
        mConnectivityManager = mContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
    }

    fun getNetworkInfo(): Network? {
        return mConnectivityManager?.activeNetwork
    }

    fun isNetworkConnected(): Boolean {
        val networkInfo = mConnectivityManager?.activeNetwork ?: return false
        return networkInfo != null
    }

    fun isWiFiConnected(): Boolean {
        return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            val network = mConnectivityManager?.activeNetwork
            val capabilities = mConnectivityManager?.getNetworkCapabilities(network)
            capabilities != null && (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI))
        } else {
            mConnectivityManager?.activeNetworkInfo!!.type == ConnectivityManager.TYPE_WIFI
        }
    }

    fun isMobileConnected(): Boolean {
        return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            val network = mConnectivityManager?.activeNetwork
            val capabilities = mConnectivityManager?.getNetworkCapabilities(network)
            capabilities != null && (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR))
        } else {
            mConnectivityManager?.activeNetworkInfo!!.type == ConnectivityManager.TYPE_MOBILE
        }
    }
}