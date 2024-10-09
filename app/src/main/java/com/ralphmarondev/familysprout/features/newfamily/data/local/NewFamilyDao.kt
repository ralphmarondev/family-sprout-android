package com.ralphmarondev.familysprout.features.newfamily.data.local

import androidx.room.Dao
import androidx.room.Upsert
import com.ralphmarondev.familysprout.core.model.Family

@Dao
interface NewFamilyDao {
    @Upsert
    suspend fun createNewFamily(family: Family)
}