package com.example.okcredit_app.Database.SupplierDatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.okcredit_app.Database.CustomerDatabase.Customer

@Dao
interface SupplierDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(supplier: Supplier)

    @Query("select * from supplier_table order by id ASC")
    fun getAllSupplier(): LiveData<List<Supplier>>


}