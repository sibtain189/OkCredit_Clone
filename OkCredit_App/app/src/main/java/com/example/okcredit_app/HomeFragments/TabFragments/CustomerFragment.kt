package com.example.okcredit_app.HomeFragments.TabFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.okcredit_app.Database.CustomerDatabase.Customer
import com.example.okcredit_app.Database.CustomerDatabase.CustomerAdapter
import com.example.okcredit_app.Database.CustomerDatabase.CustomerItemClickListener
import com.example.okcredit_app.Database.CustomerDatabase.CustomerViewModel
import com.example.okcredit_app.R
import kotlinx.android.synthetic.main.fragment_customer.*
//import com.example.okcredit_app.databinding.FragmentAccountBinding
//import com.example.okcredit_app.databinding.FragmentProfileBinding

class CustomerFragment : Fragment(R.layout.fragment_customer) , CustomerItemClickListener{

    lateinit var customerViewModel: CustomerViewModel
    lateinit var customerAdapter: CustomerAdapter
    var list: MutableList<Customer> = mutableListOf()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        customerAdapter= CustomerAdapter(list,this)
        customerRecycler.layoutManager= LinearLayoutManager(context)
        customerRecycler.adapter=customerAdapter
        val navController = findNavController()

        customerViewModel = ViewModelProviders.of(this).get(CustomerViewModel::class.java)
        customerViewModel.allCustomer.observe(viewLifecycleOwner, Observer {

            list.clear()
            list.addAll(it)
            customerAdapter.notifyDataSetChanged()

        })


        btnAddCustomer.setOnClickListener {
            val action = CustomerFragmentDirections.actionGlobalInsideCustomerFragment()
            navController.navigate(action)
        }


    }

    override fun onCustomerPosition(customer: Customer) {
        val action=CustomerFragmentDirections.actionGlobalCustomerPersonFragment(customer.name)
        findNavController().navigate(action)
    }

}
