package com.example.okcredit_app.HomeFragments.TabFragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.InvalidationTracker
import com.example.okcredit_app.Database.SupplierDatabase.Supplier
import com.example.okcredit_app.Database.SupplierDatabase.SupplierAdapter
import com.example.okcredit_app.Database.SupplierDatabase.SupplierItemClickListener
import com.example.okcredit_app.Database.SupplierDatabase.SupplierViewModel
import com.example.okcredit_app.R
import kotlinx.android.synthetic.main.fragment_supplier.*



//import com.example.okcredit_app.databinding.FragmentAccountBinding
//import com.example.okcredit_app.databinding.FragmentProfileBinding


class SupllierFragment : Fragment(R.layout.fragment_supplier), SupplierItemClickListener {

lateinit var viewModel: SupplierViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        supplierRecycler.setHasFixedSize(true)
        supplierRecycler.layoutManager= LinearLayoutManager(context)

        viewModel= ViewModelProviders.of(this).get(SupplierViewModel::class.java)
        viewModel.allCustomer.observe(viewLifecycleOwner, Observer {
            supplierRecycler.adapter=SupplierAdapter(it,this)
        })


        btnAddSupplier.setOnClickListener {

            val action = CustomerFragmentDirections.actionGlobalInsidesupplierFragment()
            navController.navigate(action)
        }
    }

    override fun onSupplierPosition(supplier: Supplier) {
        val action = SupllierFragmentDirections.actionGlobalSupplierPersonFragment(supplier.name)

        findNavController().navigate(action)

    }
}
