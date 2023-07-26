package com.whyte.demokotlin.Database

import android.content.Context
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.whyte.demokotlin.ContactViewModel.Result
import com.whyte.demokotlin.DataClass.Contact


@Database(entities = [Contact::class,Result::class], exportSchema = false, version = 2)
@TypeConverters(Convertor::class)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDAO(): ContactDAO


    //Same as Static
    companion object{

        val migration_1_2 = object : Migration(1,2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE Contact ADD COLUMN isActive INTEGER NOT NULL DEFAULT(1)")
            }

        }

        @Volatile  // on value change all thread know
       private var instance: ContactDatabase? = null

        fun getDatabase(context: Context): ContactDatabase {
            if (instance == null) {
                //For Synchronized Proses, Only Create One Instance
                synchronized(this){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ContactDatabase::class.java,"ContactDB"
                    ).addMigrations(migration_1_2).build()
                }

            }
            return instance!!
        }
    }






}