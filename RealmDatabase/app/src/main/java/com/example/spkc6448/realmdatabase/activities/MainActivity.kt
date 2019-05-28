package com.example.spkc6448.realmdatabase.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.spkc6448.realmdatabase.R
import com.example.spkc6448.realmdatabase.models.PersonneModel
import io.realm.Realm

class MainActivity : AppCompatActivity() {

    //https://realm.io/docs/java/latest
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val realm = Realm.getDefaultInstance() // opens "myrealm.realm"
        try {
            // ... Do something ...
        } finally {
            realm.close()
        }

        val personne = PersonneModel(0, "Sviatoslav")

        realm.beginTransaction()
        val person = realm.createObject(PersonneModel::class.java)
        realm.commitTransaction()
    }
}
