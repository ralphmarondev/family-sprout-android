package com.ralphmarondev.familysprout.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ralphmarondev.familysprout.core.model.User
import com.ralphmarondev.familysprout.features.auth.data.local.AuthDao

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    companion object{
        const val NAME = "familysprout"
    }

    abstract fun authDao(): AuthDao
}