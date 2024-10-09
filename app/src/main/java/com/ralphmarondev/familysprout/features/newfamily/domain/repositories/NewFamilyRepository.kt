package com.ralphmarondev.familysprout.features.newfamily.domain.repositories

import com.ralphmarondev.familysprout.core.model.Family

interface NewFamilyRepository {
    suspend fun createNewFamily(family: Family)
}