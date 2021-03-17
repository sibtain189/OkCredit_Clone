package com.example.okcredit_app.Database.SupplierDatabase

import androidx.lifecycle.LiveData

class SupplierRepository(private  val supplierDao: SupplierDao) {

    val allSupplier: LiveData<List<Supplier>> = supplierDao.getAllSupplier()

    suspend fun insert(supplier: Supplier){
        supplierDao.insert(supplier)
    }

}