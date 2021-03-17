package com.example.okcredit_app.HomeFragments.TabFragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.okcredit_app.Database.SupplierDatabase.Supplier
import com.example.okcredit_app.Database.SupplierDatabase.SupplierViewModel
import com.example.okcredit_app.R
import kotlinx.android.synthetic.main.fragment_add_supplier.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//import com.example.okcredit_app.databinding.FragmentAccountBinding
//import com.example.okcredit_app.databinding.FragmentProfileBinding


class AddSupplierFragment : Fragment(R.layout.fragment_add_supplier){

    lateinit var viewModel: SupplierViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val navController=findNavController()

        viewModel=ViewModelProviders.of(this).get(SupplierViewModel::class.java)

        btnOK.setOnClickListener {

            val name = etAddName.text.toString()

            if (name.isNotEmpty()) {
                CoroutineScope(Dispatchers.IO).launch {
                    viewModel.insert(Supplier(name))
                }

                val action = AddSupplierFragmentDirections.actionGlobalSupplierPersonFragment(name)
                navController.navigate(action)

            }
        }

    }

}