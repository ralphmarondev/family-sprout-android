package com.ralphmarondev.familysprout.features.newfamily.data.repositories

import com.ralphmarondev.familysprout.core.model.Family
import com.ralphmarondev.familysprout.features.newfamily.data.local.NewFamilyDao
import com.ralphmarondev.familysprout.features.newfamily.domain.repositories.NewFamilyRepository

class NewFamilyRepositoryImpl(
    private val familyDao: NewFamilyDao
) : NewFamilyRepository {

    override suspend fun createNewFamily(family: Family) {
        return familyDao.createNewFamily(family)
    }
}