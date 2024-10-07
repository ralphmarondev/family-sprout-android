package com.ralphmarondev.familysprout.core.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ralphmarondev.familysprout.core.util.getCurrentDateInString

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val fullName: String,
    val username: String,
    val password: String,
    val createdBy: String = "System",
    val dateCreated: String = getCurrentDateInString()
)