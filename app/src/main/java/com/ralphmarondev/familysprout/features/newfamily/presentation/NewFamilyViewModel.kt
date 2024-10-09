package com.ralphmarondev.familysprout.features.newfamily.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ralphmarondev.familysprout.MyApplication
import com.ralphmarondev.familysprout.core.model.Family
import com.ralphmarondev.familysprout.features.newfamily.data.repositories.NewFamilyRepositoryImpl
import com.ralphmarondev.familysprout.features.newfamily.domain.usecases.CreateNewFamilyUseCase
import kotlinx.coroutines.launch

class NewFamilyViewModel : ViewModel() {
    private val newFamilyDao = MyApplication.database.newFamDao()
    private val newFamRepository = NewFamilyRepositoryImpl(newFamilyDao)
    private val createNewFamilyUseCase = CreateNewFamilyUseCase(newFamRepository)

    fun createNewFamily(family: Family, response: (Boolean, String?) -> Unit) {
        viewModelScope.launch {
            createNewFamilyUseCase.createNewFamily(family, response)
        }
    }
}