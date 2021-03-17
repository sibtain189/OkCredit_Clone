package com.example.okcredit_app

import android.app.Activity
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
import androidx.viewpager2.widget.ViewPager2
import com.example.okcredit_app.VerifyAdapter.VerifyFragmentAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.fragment_give_number.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit


class GiveNumberFragment : Fragment(R.layout.fragment_give_number) {

    lateinit var auth: FirebaseAuth
    lateinit var storedVerificationId: String
    lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks
    var number: String?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            val navController=findNavController()
        auth = FirebaseAuth.getInstance()


        tvVerify.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                login()

            }

        }

        callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
               val action=GiveNumberFragmentDirections.actionGiveNumberFragmentToEnterNameFragment6(number!!)
                navController.navigate(action)
            }

            override fun onVerificationFailed(e: FirebaseException) {
                Toast.makeText(context, "Failed", Toast.LENGTH_LONG).show()
            }

            override fun onCodeSent(verificationId: String, token: PhoneAuthProvider.ForceResendingToken) {

                Log.d("TAG","onCodeSent:$verificationId")
                storedVerificationId = verificationId
                resendToken = token

                number=etNumber.text.toString()
                val action=GiveNumberFragmentDirections.
                actionGiveNumberFragmentToOTPFragment4(storedVerificationId,number!!)
                navController.navigate(action)

            }
    }
    }

    private fun login() {
//        val mobileNumber = view.findViewById<EditText>(R.id.etNumber)
            var number = etNumber.text.toString().trim()

            if (!number.isEmpty()) {
                number = "+91" + number
                sendVerificationCode (number)
            } else {
                Toast.makeText(context, "Enter mobile number", Toast.LENGTH_SHORT).show()
            }
    }

    private fun sendVerificationCode(number: String) {
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(number) // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(context as Activity) // Activity (for callback binding)
            .setCallbacks(callbacks) // OnVerificationStateChangedCallbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }


}
