package com.ralphmarondev.familysprout.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ralphmarondev.familysprout.core.model.Family
import com.ralphmarondev.familysprout.core.model.User
import com.ralphmarondev.familysprout.features.auth.data.local.AuthDao
import com.ralphmarondev.familysprout.features.newfamily.data.local.NewFamilyDao

@Database(
    entities = [User::class, Family::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val NAME = "familysprout"
    }

    abstract fun authDao(): AuthDao
    abstract fun newFamDao(): NewFamilyDao
}