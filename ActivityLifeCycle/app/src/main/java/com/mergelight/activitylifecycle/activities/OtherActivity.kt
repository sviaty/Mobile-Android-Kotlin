package com.mergelight.activitylifecycle.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mergelight.activitylifecycle.R
import com.mergelight.activitylifecycle.constants.Constants


class OtherActivity : AppCompatActivity() {

    lateinit var mBtnGoToMainActivity: Button
    var valueBundle: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)
        Log.d("Activity life cycle 2", " onCreate")

        loadDataBundle()
        setupView()
        setupListenner()
    }

    override fun onStart() {
        super.onStart()
        Log.d("Activity life cycle 2", " onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Activity life cycle 2", " onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Activity life cycle 2", " onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Activity life cycle 2", " onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Activity life cycle 2", " onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Activity life cycle 2", " onDestroy")
    }

    private fun setupView(){
        mBtnGoToMainActivity = findViewById(R.id.btn_go_to_main_activity)
    }

    private fun setupListenner() {
        mBtnGoToMainActivity.setOnClickListener {
            changeActivity()
        }
    }

    private fun loadDataBundle() {
        val intentExtras = intent.extras
        if (intentExtras != null) {
            valueBundle = intentExtras.getString(Constants.KEYS_DATA_BUNDLE_MAIN_ACTIVITY)
            Toast.makeText(applicationContext, valueBundle ,Toast.LENGTH_SHORT).show()
        }
    }

    private fun changeActivity(){
        val intent = Intent(this@OtherActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}