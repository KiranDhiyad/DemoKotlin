package com.whyte.demokotlin

import android.app.Application
import com.whyte.demokotlin.Api.ApiInterface
import com.whyte.demokotlin.Api.RetrofitHelper
import com.whyte.demokotlin.Database.ContactDatabase
import com.whyte.demokotlin.Repository.QuoteRepo

class application : Application() {

    lateinit var quoteRepo: QuoteRepo

    override fun onCreate() {
        super.onCreate()

        initialize()
    }

    private fun initialize() {
        val apiInterface = RetrofitHelper.getInstance().create(ApiInterface::class.java)
        val database = ContactDatabase.getDatabase(applicationContext)
        quoteRepo = QuoteRepo(apiInterface,database)
    }
}