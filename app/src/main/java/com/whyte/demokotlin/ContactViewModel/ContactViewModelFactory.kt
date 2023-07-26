package com.whyte.demokotlin.ContactViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.whyte.demokotlin.Repository.QuoteRepo

class ContactViewModelFactory(private val quoteRepo: QuoteRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ContactViewModel(quoteRepo) as T
    }

}