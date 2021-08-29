package com.example.githubrepository.data.network.service

import com.example.githubrepository.domain.model.UserRepo
import retrofit2.http.GET
import retrofit2.http.Path

interface UserRepositoryService {

    @GET("users/{id}/repos")
    suspend fun getUserRepo(@Path("id") id: String): List<UserRepo>
}