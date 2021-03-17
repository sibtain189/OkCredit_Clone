package com.example.okcredit_app.Database.CustomerDatabase

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CustomerViewModel(application: Application): AndroidViewModel(application) {

    private val repository: CustomerRepository
   val allCustomer: LiveData<List<Customer>>


    init {

        val dao= CustomerDatabase.getDatabase(application).getCustomerDao()
        repository=CustomerRepository(dao)
        allCustomer=repository.allCustomer

    }

    suspend fun insertCustomer(customer: Customer)= viewModelScope.launch(Dispatchers.IO) {
        repository.insert(customer)
    }
}
