package com.example.githubrepository.domain.model

import com.google.gson.annotations.SerializedName

data class UserRepo(
    val id: Int,
    val name: String?,
    val description: String?,
    @SerializedName("created_at") val createdAt: String?
)