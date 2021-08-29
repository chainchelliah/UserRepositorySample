package com.example.githubrepository.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.githubrepository.domain.model.UserRepo
import com.google.gson.annotations.SerializedName

@Entity(tableName = "UserRepository")
data class UserRepoEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String?,
    val description: String?,
    @SerializedName("created_at")
    val createdAt: String?
)

fun UserRepoEntity.toDomainModel() =
    UserRepo(
        this.id, this.name, this.description, this.createdAt
    )
