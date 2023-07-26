package com.whyte.demokotlin.Database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.whyte.demokotlin.DataClass.Contact
import com.whyte.demokotlin.ContactViewModel.Result


@Dao
interface ContactDAO {

    @Insert
    suspend fun insertContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("SELECT * FROM Contact")
    fun getContact() : LiveData<List<Contact>>  //Default Background thread implements

    @Insert
    suspend fun insertQuote(result: List<Result>)

    @Query("SELECT * FROM quote")
    fun getQuote() : List<Result>  //Default Background thread implements
}