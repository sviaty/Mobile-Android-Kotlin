package com.example.spkc6448.keystore

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val keyStoreEncryptDecrypt = KeyStoreEncryptDecrypt(this)
        val encrypt = keyStoreEncryptDecrypt.encryptData("test")
        Log.d("keyStore ", "encrypt : $encrypt")

        val decrypt = keyStoreEncryptDecrypt.decryptData(encrypt)
        Log.d("keyStore ", "decrypt : $decrypt")

        /**
         * - Save
         * 1) générer clef priv et pub
         * 2) crypter le text avec un algo
         * 3) stocker ds le keystore les clefs priv et pub
         * 4) stocker ds les preferences data le text crypter
         * - Load
         * 5) récupérer les clefs priv et pub dans le keystore
         * 6) récupérer le text crypter dans les preferences data
         * 7) decrypter le text avec un algo
         */

        KeyStoreManager.leSuperTest()
    }
}
