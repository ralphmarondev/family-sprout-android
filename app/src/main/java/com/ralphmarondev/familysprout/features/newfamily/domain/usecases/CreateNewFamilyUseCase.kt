package com.ralphmarondev.familysprout.features.newfamily.domain.usecases

import android.util.Log
import com.ralphmarondev.familysprout.core.model.Family
import com.ralphmarondev.familysprout.features.newfamily.domain.repositories.NewFamilyRepository

class CreateNewFamilyUseCase(private val familyRepository: NewFamilyRepository) {
    suspend fun createNewFamily(family: Family, response: (Boolean, String?) -> Unit) {
        try {
            familyRepository.createNewFamily(family)
            response(true, null)
        } catch (ex: Exception) {
            Log.d("NEW_FAMILY", "ERROR: ${ex.message}")
            response(false, ex.message)
        }
    }
}