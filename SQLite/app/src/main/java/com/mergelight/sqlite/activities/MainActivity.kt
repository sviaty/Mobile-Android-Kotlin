package com.mergelight.sqlite.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mergelight.sqlite.R
import com.mergelight.sqlite.models.Contact
import com.mergelight.sqlite.sqlite.DBSqlLiteHelperContact

class MainActivity : AppCompatActivity() {
    private lateinit var dBSqlLiteHelperContact: DBSqlLiteHelperContact

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dBSqlLiteHelperContact = DBSqlLiteHelperContact(this)

        val contact = Contact(null,"Sviaty", "06")
        dBSqlLiteHelperContact.insertContact(contact)

        var contactList = dBSqlLiteHelperContact.getAllCotacts()

        for (contact in contactList) {
            dBSqlLiteHelperContact.getContact(contact.mIdContact!!)
        }
    }
}