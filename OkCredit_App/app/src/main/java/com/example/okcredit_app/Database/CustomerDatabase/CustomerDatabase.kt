package com.example.okcredit_app.Database.CustomerDatabase

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.okcredit_app.Database.ProfileDatabase.ProfileDao
import com.example.okcredit_app.Database.ProfileDatabase.ProfileEntity
import com.example.okcredit_app.Database.SupplierDatabase.Supplier
import com.example.okcredit_app.Database.SupplierDatabase.SupplierDao

@Database(entities = [Customer::class, Supplier::class, ProfileEntity::class],version = 3,exportSchema = false)
 abstract class CustomerDatabase() :RoomDatabase(){

    abstract fun getCustomerDao(): CustomerDao
    abstract fun getSupplierDao(): SupplierDao
    abstract fun getProfileDao(): ProfileDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.

        private var INSTANCE:CustomerDatabase?=null
        fun getDatabase(context: Context):CustomerDatabase{
            if(INSTANCE==null){
                val builder:Builder<CustomerDatabase> = Room.databaseBuilder(
                    context.applicationContext,
                    CustomerDatabase::class.java,
                    "customer_database"
                )
                builder.fallbackToDestructiveMigration()
                return builder.build()
                return INSTANCE!!
            }else{
                return INSTANCE!!
            }
        }
    }
}