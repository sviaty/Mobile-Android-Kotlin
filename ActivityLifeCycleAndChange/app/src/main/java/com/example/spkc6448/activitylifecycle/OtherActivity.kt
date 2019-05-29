package com.example.spkc6448.activitylifecycle

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_other.*

class OtherActivity : AppCompatActivity() {

    lateinit var value: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        loadDataBundle()
        setupListenner()
    }

    private fun setupListenner() {
        btn_go_to_main_activity.setOnClickListener {
            changeActivity()
        }
    }

    private fun loadDataBundle() {
        val b = intent.extras
        if (b != null)
            value = b.getString("key")
    }

    private fun changeActivity(){
        val intent = Intent(this@OtherActivity, MainActivity::class.java)
        val b = Bundle()
        b.putString("key", "test OtherActivity")
        intent.putExtras(b)
        startActivity(intent)
        finish()
    }
}