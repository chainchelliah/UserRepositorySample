package com.example.githubrepository.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.githubrepository.data.database.entity.UserRepoEntity

@Dao
interface UserRepoDao {

    @Query("SELECT * FROM UserRepository")
    fun getAll(): List<UserRepoEntity>
}