package com.mergelight.permissions

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var mEditTextNumero: EditText
    private lateinit var mBtnCall: Button

    private val CALL_PHONE_PERMISSIONS = 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
        setupListenner()
    }

    private fun setupView(){
        mEditTextNumero = findViewById(R.id.et_num)
        mBtnCall = findViewById(R.id.btn_call)
    }

    private fun setupListenner() {
        mBtnCall.setOnClickListener {
            testPermissionCall()
        }
    }

    private fun testPermissionCall() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), CALL_PHONE_PERMISSIONS)
        } else {
            actionCall()
        }
    }

    private fun actionCall() {
        val number = mEditTextNumero.text.toString()
        val callIntent = Intent(Intent.ACTION_CALL)
        callIntent.data = Uri.parse("tel: $number")

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return
        }
        startActivity(callIntent)

        Toast.makeText(this@MainActivity, "call ok", Toast.LENGTH_SHORT).show()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            CALL_PHONE_PERMISSIONS -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted
                    Toast.makeText(this@MainActivity, "Permission CALL_PHONE_PERMISSIONS ok", Toast.LENGTH_SHORT).show()
                    actionCall()
                } else {
                    // Permission Denied
                    Toast.makeText(this@MainActivity, "Permission CALL_PHONE_PERMISSIONS Denied", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            else -> super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        }
    }
}