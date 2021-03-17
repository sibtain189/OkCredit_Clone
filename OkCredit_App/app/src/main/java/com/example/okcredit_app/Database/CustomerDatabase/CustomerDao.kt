package com.example.okcredit_app.Database.CustomerDatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.selects.select


@Dao
interface CustomerDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(customer: Customer)

    @Query("select * from customer_table order by id ASC")
    fun getAllCustomer(): LiveData<List<Customer>>

}