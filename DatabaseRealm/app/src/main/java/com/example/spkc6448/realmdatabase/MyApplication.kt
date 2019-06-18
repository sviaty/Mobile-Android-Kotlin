package com.example.spkc6448.realmdatabase

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration



class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // The default Realm file is "default.realm" in Context.getFilesDir();
        // we'll change it to "myrealm.realm"

        Realm.init(this)
        val config = RealmConfiguration.Builder().name("myrealm.realm").build()
        Realm.setDefaultConfiguration(config)
    }
}