package com.whyte.demokotlin.Api

import com.whyte.demokotlin.ContactViewModel.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page : Int) : Response<QuoteList>

}