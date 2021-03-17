package com.example.okcredit_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {


    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth= FirebaseAuth.getInstance()
        var currentUser=auth.currentUser


        if(currentUser!=null){

            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
            finish()

        }

    }
}