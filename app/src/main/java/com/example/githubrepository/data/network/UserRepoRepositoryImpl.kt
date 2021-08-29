package com.example.githubrepository.data.network

import com.example.githubrepository.data.database.dao.UserRepoDao
import com.example.githubrepository.data.database.entity.toDomainModel
import com.example.githubrepository.data.network.service.UserRepositoryService
import com.example.githubrepository.domain.model.UserRepo
import com.example.githubrepository.domain.repository.UserRepoRepository
import java.net.UnknownHostException

class UserRepoRepositoryImpl(
    private val userRepositoryService: UserRepositoryService,
    private val userRepoDao: UserRepoDao
) : UserRepoRepository {
    override suspend fun getUserRepo(id: String): List<UserRepo> {
        return try {
            userRepositoryService.getUserRepo(id)
        } catch (e: UnknownHostException) {
            userRepoDao.getAll().map { it.toDomainModel() }
        }
    }
}