package com.example.okcredit_app

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import com.example.okcredit_app.VerifyAdapter.VerifyFragmentAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.fragment_otp.*


class OTPFragment : Fragment(R.layout.fragment_otp) {

    private val args:OTPFragmentArgs by navArgs()
    lateinit var auth: FirebaseAuth
    private var number: String?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController= findNavController()
        auth=FirebaseAuth.getInstance()

        var storedVerificationId=args.receiver
        number=args.number

        tvSentence.text="Your OTP will be delivered soon +91$number"

        btnVerify.setOnClickListener {
            var otp=pinView.text.toString().trim()
            if(!otp.isEmpty()){
                val credential : PhoneAuthCredential = PhoneAuthProvider.getCredential(
                    storedVerificationId.toString(), otp)
                signInWithPhoneAuthCredential(credential)
            }else{
                Toast.makeText(context,"Enter OTP",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        val navController=findNavController()
        auth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val action = OTPFragmentDirections.actionOTPFragmentToEnterNameFragment(number!!)
                    navController.navigate(action)
// ...
                } else {
// Sign in failed, display a message and update the UI
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
// The verification code entered was invalid
                        Toast.makeText(context,"Invalid OTP",Toast.LENGTH_SHORT).show()
                    }
                }
            }
    }
}
