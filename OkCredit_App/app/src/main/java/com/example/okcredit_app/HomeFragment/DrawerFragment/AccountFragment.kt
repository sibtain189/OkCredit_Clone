package com.example.okcredit_app.HomeFragment.DrawerFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.okcredit_app.R
import kotlinx.android.synthetic.main.fragment_account.*

//import com.example.okcredit_app.databinding.FragmentAccountBinding


class AccountFragment : Fragment(R.layout.fragment_account){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController=findNavController()

        cdCustomer.setOnClickListener {

            val action=AccountFragmentDirections.actionGlobalCustomerFragment()
            navController.navigate(action)

        }

        cdSupplier.setOnClickListener {

            val action=AccountFragmentDirections.actionGlobalSupllierFragment()
            navController.navigate(action)

        }

    }


}

