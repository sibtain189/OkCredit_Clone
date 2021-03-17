package com.example.okcredit_app.Database.ProfileDatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.okcredit_app.Database.CustomerDatabase.Customer
@Dao
interface ProfileDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(profileEntity: ProfileEntity)

    @Query("select * from profile_table order by id ASC")
    fun getAll(): LiveData<List<ProfileEntity>>

}