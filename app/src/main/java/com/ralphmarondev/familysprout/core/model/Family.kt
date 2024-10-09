package com.ralphmarondev.familysprout.core.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ralphmarondev.familysprout.core.util.getCurrentDateInString

@Entity
data class Family(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val husband: Int,
    val husbandName: String,
    val wife: Int,
    val wifeName: String,
    val childCount: Int = 0,
    val homeTown: String,
    val remarks: String,
    val createdBy: String = "System",
    val dateCreated: String = getCurrentDateInString(),
    val isDeleted: Boolean = false
)