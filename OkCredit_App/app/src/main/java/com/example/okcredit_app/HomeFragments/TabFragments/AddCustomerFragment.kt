package com.example.okcredit_app.HomeFragments.TabFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.okcredit_app.Database.CustomerDatabase.Customer
import com.example.okcredit_app.Database.CustomerDatabase.CustomerViewModel
import com.example.okcredit_app.R
import kotlinx.android.synthetic.main.fragment_add_customer.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//import com.example.okcredit_app.databinding.FragmentAccountBinding
//import com.example.okcredit_app.databinding.FragmentProfileBinding


class AddCustomerFragment : Fragment(R.layout.fragment_add_customer) {

    lateinit var customerViewModel: CustomerViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val navController = findNavController()

        customerViewModel = ViewModelProviders.of(this).get(CustomerViewModel::class.java)


        tvAddPerson.setOnClickListener {

            val name = etName.text.toString()

            if (!name.isEmpty()) {
                CoroutineScope(Dispatchers.IO).launch {
                    customerViewModel.insertCustomer(Customer(name))
                }

                val action = AddCustomerFragmentDirections.actionGlobalCustomerPersonFragment(name)
                navController.navigate(action)

            }

        }
    }
}
