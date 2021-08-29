package com.example.githubrepository.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.githubrepository.data.database.dao.UserRepoDao
import com.example.githubrepository.data.database.entity.UserRepoEntity

@Database(entities = [UserRepoEntity::class], version = 1, exportSchema = false)
abstract class UserRepoAppDataBase : RoomDatabase() {
    abstract fun userRepoDao(): UserRepoDao
}