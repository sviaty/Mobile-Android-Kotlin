package com.example.spkc6448.wifiinformation.internetManager

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo

class NetworkManager(context: Context) {

    var mContext: Context = context
    var conMgr: ConnectivityManager?

    init {
        conMgr = mContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
    }

    fun getNetworkInfo(): NetworkInfo? {
        return conMgr?.activeNetworkInfo
    }

    fun isNetworkConnected(): Boolean {
        val networkInfo: NetworkInfo? = conMgr?.activeNetworkInfo
        return when (networkInfo) {
            NetworkInfo.State.CONNECTED -> {
                true
            }
            NetworkInfo.State.DISCONNECTED -> {
                false
            }
            else -> {
                false
            }
        }
    }

    fun isWiFiConnected(): Boolean {
        return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            val network = conMgr?.activeNetwork
            val capabilities = conMgr?.getNetworkCapabilities(network)
            capabilities != null && (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI))
        } else {
            conMgr?.activeNetworkInfo!!.type == ConnectivityManager.TYPE_WIFI
        }
    }

    fun isMobileConnected(): Boolean {
        return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            val network = conMgr?.activeNetwork
            val capabilities = conMgr?.getNetworkCapabilities(network)
            capabilities != null && (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR))
        } else {
            conMgr?.activeNetworkInfo!!.type == ConnectivityManager.TYPE_MOBILE
        }
    }
}