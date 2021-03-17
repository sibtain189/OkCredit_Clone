package com.example.okcredit_app.HomeFragment.DrawerFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.okcredit_app.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_setting.*

//import com.example.okcredit_app.databinding.FragmentSettingBinding


class SettingFragment : Fragment(R.layout.fragment_setting){

    lateinit var auth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth= FirebaseAuth.getInstance()
        val navController=findNavController()

        vSignOut.setOnClickListener {

            auth.signOut()
            val action=SettingFragmentDirections.actionSettingFragmentToLoginActivity()
            navController.navigate(action)


        }


    }
}