package com.whyte.demokotlin.Repository

import androidx.lifecycle.LiveData
import com.whyte.demokotlin.DataClass.Contact
import com.whyte.demokotlin.Database.ContactDAO

class ContactRepo(private val contactDAO: ContactDAO) {

    fun getContact(): LiveData<List<Contact>>{
        return contactDAO.getContact()
    }

    suspend fun insertContact(contact: Contact){
        contactDAO.insertContact(contact)
    }
}