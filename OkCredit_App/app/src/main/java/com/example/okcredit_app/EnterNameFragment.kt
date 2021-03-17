package com.example.okcredit_app

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import com.example.okcredit_app.Database.CustomerDatabase.CustomerDatabase
import com.example.okcredit_app.Database.ProfileDatabase.ProfileEntity
import com.example.okcredit_app.VerifyAdapter.VerifyFragmentAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.fragment_enter_name.*
import kotlinx.android.synthetic.main.fragment_give_number.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit


class EnterNameFragment : Fragment(R.layout.fragment_enter_name){

    private val args: EnterNameFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val navController= findNavController()

        tvNext.setOnClickListener {
        val number=args.number
            val name= etName.text.toString()
            if (name.isEmpty()){
                etName.error="Name Required"
                etName.requestFocus()
                return@setOnClickListener
            }
            CoroutineScope(Dispatchers.IO).launch {
                context?.let {
                    val profileEntity= ProfileEntity(name,number)
                    CustomerDatabase.getDatabase(it).getProfileDao().insert(profileEntity)
                }

            }

            val action=EnterNameFragmentDirections.actionEnterNameFragmentToHomeActivity2()
            navController.navigate(action)
        }
    }
}


