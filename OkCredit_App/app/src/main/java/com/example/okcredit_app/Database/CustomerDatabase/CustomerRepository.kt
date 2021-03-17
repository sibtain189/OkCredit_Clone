package com.example.okcredit_app.Database.CustomerDatabase

import androidx.lifecycle.LiveData

class CustomerRepository(private val customerDao: CustomerDao) {

    val allCustomer: LiveData<List<Customer>> = customerDao.getAllCustomer()

    suspend fun insert(customer: Customer)
    {
        customerDao.insert(customer)
    }
}