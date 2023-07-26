package com.whyte.demokotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.whyte.demokotlin.databinding.ActivityMainBinding
import com.whyte.demokotlin.ContactViewModel.ContactViewModel
import com.whyte.demokotlin.ContactViewModel.ContactViewModelFactory
import com.whyte.demokotlin.DataClass.Contact
import com.whyte.demokotlin.Database.ContactDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var databse :ContactDatabase
    lateinit var contactViewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val dao  = ContactDatabase.getDatabase(this).contactDAO()
//        val repository = ContactRepo(dao)
//
//        val apiInterface = RetrofitHelper.getInstance().create(ApiInterface::class.java)
//        val quoteRepo = QuoteRepo(apiInterface)

        val repository = (application as application).quoteRepo

        contactViewModel = ViewModelProvider(this,ContactViewModelFactory(repository))[ContactViewModel::class.java]

        databse = ContactDatabase.getDatabase(this)

//        contactViewModel.getContact().observe(this, androidx.lifecycle.Observer {
//
//        })
//
//        contactViewModel.getContact().observe(this, androidx.lifecycle.Observer {
//
//        })

        contactViewModel.quotes.observe(this, androidx.lifecycle.Observer {
            Log.d("Response Data",it.results.toString())

        })

        GlobalScope.launch {
            databse.contactDAO().insertContact(Contact(0,"Karan","1234567890", Date(),1))
        }



        binding.tx1.text = "Hello this is karan"

        binding.tx1.setOnClickListener{
            startActivity(Intent(applicationContext,SecondActivity::class.java))
        }

    }
}