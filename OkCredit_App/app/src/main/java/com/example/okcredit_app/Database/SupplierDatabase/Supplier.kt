package com.example.okcredit_app.Database.SupplierDatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "supplier_table")
class Supplier (@ColumnInfo(name = "name")val name:String){

    @PrimaryKey(autoGenerate = true) var id=0
}