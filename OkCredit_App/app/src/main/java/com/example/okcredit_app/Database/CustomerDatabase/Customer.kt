package com.example.okcredit_app.Database.CustomerDatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "customer_table")
class Customer(@ColumnInfo(name = "name") val name: String){

    @PrimaryKey(autoGenerate = true)var id=0

}