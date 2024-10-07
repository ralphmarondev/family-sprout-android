package com.ralphmarondev.familysprout

import android.app.Application
import androidx.room.Room
import com.ralphmarondev.familysprout.core.data.local.AppDatabase

class MyApplication : Application() {
    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            AppDatabase.NAME
        ).build()
    }
}