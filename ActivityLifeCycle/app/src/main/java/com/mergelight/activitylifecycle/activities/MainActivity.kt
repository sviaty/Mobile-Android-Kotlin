package com.mergelight.activitylifecycle.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.mergelight.activitylifecycle.R
import com.mergelight.activitylifecycle.constants.Constants

class MainActivity : AppCompatActivity() {

    lateinit var mBtnGoToOtherActivity: Button
    var valueBundle: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Activity Life cycle 1", " onCreate")

    }

    override fun onStart() {
        super.onStart()
        Log.d("Activity life cycle 1", " onStart")

        setupView()
        setupListenner()
        loadDataBundle()
    }

    override fun onResume() {
        super.onResume()
        Log.d("Activity life cycle 1", " onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Activity life cycle 1", " onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Activity life cycle 1", " onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Activity life cycle 1", " onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Activity life cycle 1", " onDestroy")
    }

    private fun setupView(){
        mBtnGoToOtherActivity = findViewById(R.id.btn_go_to_next_activity)
    }

    private fun setupListenner() {
        mBtnGoToOtherActivity.setOnClickListener {
            changeActivity()
        }
    }

    private fun loadDataBundle() {
        val b = intent.extras
        if (b != null)
            valueBundle = b.getString(Constants.KEYS_DATA_BUNDLE_OTHER_ACTIVITY)
            Toast.makeText(applicationContext, valueBundle , Toast.LENGTH_SHORT).show()
    }

    private fun changeActivity(){
        Log.d("Activity life cycle ", "Go to second activity")

        val b = Bundle()
        b.putString(Constants.KEYS_DATA_BUNDLE_MAIN_ACTIVITY, "test passing datas beetwin two activities")

        val intent = Intent(this@MainActivity, OtherActivity::class.java)
        intent.putExtras(b)
        startActivity(intent)
        finish()
    }
}