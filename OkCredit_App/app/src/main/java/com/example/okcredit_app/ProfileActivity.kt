package com.example.okcredit_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.okcredit_app.Database.CustomerDatabase.CustomerDatabase
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        toolBarProfile.setOnClickListener {

            val intent= Intent(this,HomeActivity::class.java)
            startActivity(intent)
            finish()

        }

        val database=CustomerDatabase.getDatabase(this).getProfileDao()
        database.getAll().observe(this, Observer {

            businessName.text=it[0].name
            mobileNumber.text=it[0].phoneNumber

        })
    }
}