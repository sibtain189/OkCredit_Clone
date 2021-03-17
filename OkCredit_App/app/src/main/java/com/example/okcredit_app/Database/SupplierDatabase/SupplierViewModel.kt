package com.example.okcredit_app.Database.SupplierDatabase

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.okcredit_app.Database.CustomerDatabase.CustomerDatabase

class SupplierViewModel(application: Application): AndroidViewModel(application) {

    val repository: SupplierRepository
    val allCustomer: LiveData<List<Supplier>>

    init {

        val dao= CustomerDatabase.getDatabase(application).getSupplierDao()
        repository=SupplierRepository(dao)
        allCustomer=repository.allSupplier

    }

    suspend fun insert(supplier: Supplier){

        repository.insert(supplier)
    }

}