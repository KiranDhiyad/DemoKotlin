package com.whyte.demokotlin.ContactViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.whyte.demokotlin.Repository.QuoteRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactViewModel(private val quoteRepo: QuoteRepo) : ViewModel() {


    init {
        viewModelScope.launch(Dispatchers.IO) {
            quoteRepo.getQuotes(1)
        }
    }

    val quotes : LiveData<QuoteList>
    get() = quoteRepo.quotes

//    fun getContact(): LiveData<List<Contact>> {
//        return contactRepo.getContact()
//    }
//
//    fun insertContact(contact: Contact){
//        viewModelScope.launch {
//            contactRepo.insertContact(contact)
//
//        }
//    }
}