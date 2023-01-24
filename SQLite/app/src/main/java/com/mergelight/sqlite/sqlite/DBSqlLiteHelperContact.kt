package com.mergelight.sqlite.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.DatabaseUtils
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.mergelight.sqlite.constants.Constants
import com.mergelight.sqlite.models.Contact

class DBSqlLiteHelperContact(context: Context) : SQLiteOpenHelper(context, Constants.DATABASE_NAME, null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "create table " + Constants.CONTACTS_TABLE_NAME + " " +
                    "(" + Constants.CONTACTS_COLUMN_ID + " integer primary key, " +
                    "" + Constants.CONTACTS_COLUMN_NOM + " text," +
                    "" + Constants.CONTACTS_COLUMN_TEL + " text)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + Constants.CONTACTS_TABLE_NAME)
        onCreate(db)
    }

    fun insertContact(contact: Contact): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(Constants.CONTACTS_COLUMN_NOM, contact.mNameContact)
        contentValues.put(Constants.CONTACTS_COLUMN_TEL, contact.mTelContact)
        db.insert(Constants.CONTACTS_TABLE_NAME, null, contentValues)
        return true
    }

    fun updateContact(contact: Contact): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(Constants.CONTACTS_COLUMN_NOM, contact.mNameContact)
        contentValues.put(Constants.CONTACTS_COLUMN_TEL, contact.mTelContact)
        db.update(
            Constants.CONTACTS_TABLE_NAME,
            contentValues,
            Constants.CONTACTS_COLUMN_ID + " = ? ",
            arrayOf(Integer.toString(contact.mIdContact!!))
        )
        return true
    }

    fun deleteContactWithId(id: Int?): Int? {
        val db = this.writableDatabase
        return db.delete(
            Constants.CONTACTS_TABLE_NAME,
            Constants.CONTACTS_COLUMN_ID + " = ? ",
            arrayOf(Integer.toString(id!!))
        )
    }

    fun numberOfContact(): Int {
        val db = this.readableDatabase
        return DatabaseUtils.queryNumEntries(db, Constants.CONTACTS_TABLE_NAME).toInt()
    }

    fun getContact(id: Int): Cursor {
        val db = this.readableDatabase
        return db.rawQuery(
            ("select * from " + Constants.CONTACTS_TABLE_NAME +
                    " where " + Constants.CONTACTS_COLUMN_ID + "=" + id + ""), null
        )
    }

    fun getAllCotacts(): List<Contact> {
        val array_list = arrayListOf<Contact>()

        val db = this.readableDatabase
        val res = db.rawQuery("select * from " + Constants.CONTACTS_TABLE_NAME, null)
        res.moveToFirst()
        if(res != null) {
            while (!res.isAfterLast) {
                val contact = Contact()

                val i = res.getColumnIndex(Constants.CONTACTS_COLUMN_ID)
                if(i >= 0){
                    val idContact: Int = res.getInt(i)
                    contact.mIdContact = idContact
                }

                val i2 = res.getColumnIndex(Constants.CONTACTS_COLUMN_NOM)
                if(i2 >= 0){
                    val nameContact: String = res.getString(i2)
                    contact.mNameContact = nameContact
                }

                val i3 = res.getColumnIndex(Constants.CONTACTS_COLUMN_TEL)
                if(i3 >= 0){
                    val telContact: String = res.getString(i3)
                    contact.mTelContact = telContact
                }

                //val contact = Contact(idContact, nameContact, telContact)
                array_list.add(contact)

                res.moveToNext()
            }
        }
        return array_list
    }
}