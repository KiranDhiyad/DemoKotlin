package com.whyte.demokotlin.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.whyte.demokotlin.Api.ApiInterface
import com.whyte.demokotlin.ContactViewModel.QuoteList
import com.whyte.demokotlin.Database.ContactDatabase

class QuoteRepo(private val apiInterface: ApiInterface,private val contactDatabase: ContactDatabase) {

    private val quotesLiveData = MutableLiveData<QuoteList>()
    val quotes : LiveData<QuoteList>
    get()= quotesLiveData

    suspend fun getQuotes(page : Int){
        val result = apiInterface.getQuotes(page)
        if (result?.body() != null){
            contactDatabase.contactDAO().insertQuote(result.body()!!.results)
            quotesLiveData.postValue(result.body())
        }
    }
}