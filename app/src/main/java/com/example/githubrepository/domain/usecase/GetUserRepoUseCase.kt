package com.example.githubrepository.domain.usecase

import com.example.githubrepository.domain.model.UserRepo
import com.example.githubrepository.domain.repository.UserRepoRepository
import java.io.IOException

class GetUserRepoUseCase(private val userRepoRepository: UserRepoRepository) {

    sealed interface Result {
        data class Success(val data: List<UserRepo>) : Result
        data class Error(val e: Throwable) : Result
    }

    suspend fun execute(): Result {

        //TODO should pass from view
        val id = "chainchelliah"

        return try {
            Result.Success(userRepoRepository.getUserRepo(id))
        } catch (e: IOException) {
            Result.Error(e)
        }
    }
}