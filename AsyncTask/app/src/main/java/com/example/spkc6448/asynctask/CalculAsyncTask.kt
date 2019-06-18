package com.example.spkc6448.asynctask

import android.os.AsyncTask
import android.util.Log

class CalculAsyncTask : AsyncTask<String, Int, Int>() {

    override fun onPreExecute() {
        super.onPreExecute()

        Log.i("onPreExecute : ", "Start asyncTask")
    }

    override fun doInBackground(vararg arg0: String): Int? {
        var a: Int? = 0
        for (i in 0..999999) {
            a = a!! + 1
        }
        return a
    }

    override fun onPostExecute(result: Int?) {
        Log.i("onPostExecute", "End asyncTask")

        if (result != null) {
            Log.d("calculAsyncTask", "a = $result")
        }
    }
}