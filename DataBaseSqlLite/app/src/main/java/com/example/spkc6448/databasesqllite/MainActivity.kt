package com.example.spkc6448.databasesqllite

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private lateinit var dBSqlLiteHelperContact: DBSqlLiteHelperContact

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dBSqlLiteHelperContact = DBSqlLiteHelperContact(this)

        addContact()

        var contactList = dBSqlLiteHelperContact.getAllCotacts()

        for (contact in contactList) {
            dBSqlLiteHelperContact.getContact(contact.idContact!!)
        }
    }

    private fun addContact(){
        val contact = Contact(null,"Sviaty", "06")
        dBSqlLiteHelperContact.insertContact(contact)
    }


}
