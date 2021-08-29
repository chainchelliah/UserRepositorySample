package com.example.githubrepository.domain.repository

import com.example.githubrepository.domain.model.UserRepo

interface UserRepoRepository {

    suspend fun getUserRepo(id: String): List<UserRepo>

}