package com.example.okcredit_app.Database.ProfileDatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profile_table")
data class ProfileEntity(val name: String, val phoneNumber: String){

    @PrimaryKey(autoGenerate = true) var id: Int=0
}