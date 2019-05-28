package com.example.spkc6448.realmdatabase.models

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.Ignore
import io.realm.annotations.PrimaryKey

class PersonneModel(id:Long, name:String) : RealmObject() {

    @PrimaryKey
    private val id: Long = 0
    private val name: String? = null
    //private val dogs: RealmList<DogModel>? = null

    @Ignore
    private val sessionId: Int = 0

}