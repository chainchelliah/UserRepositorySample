package com.example.githubrepository.di

import androidx.room.Room
import com.example.githubrepository.data.database.UserRepoAppDataBase
import com.example.githubrepository.data.network.UserRepoRepositoryImpl
import com.example.githubrepository.data.network.service.UserRepositoryService
import com.example.githubrepository.domain.repository.UserRepoRepository
import com.example.githubrepository.domain.usecase.GetUserRepoUseCase
import com.example.githubrepository.helper.Constants.BASE_URL
import com.example.githubrepository.helper.Constants.DB_NAME
import com.example.githubrepository.helper.createNetworkClient
import com.example.githubrepository.presentation.userRepoList.UserRepositoryViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import retrofit2.Retrofit

fun injectModules() = loadModules

private val loadModules by lazy {
    loadKoinModules(listOf(viewModelModule, repositoryModule, roomModule))
}

val viewModelModule = module {
    single { return@single GetUserRepoUseCase(get()) }
    viewModel { UserRepositoryViewModel(getUserRepoUseCase = get()) }
}

val repositoryModule = module {
    single<UserRepoRepository> {
        return@single UserRepoRepositoryImpl(
            userRepositoryService = userApiService,
            get()
        )
    }
}

val roomModule = module {
    single {
        Room.databaseBuilder(androidApplication(), UserRepoAppDataBase::class.java, DB_NAME)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries() // TODO should allow CRUD operation on background thread
            .build()
    }
    single { get<UserRepoAppDataBase>().userRepoDao() }
}

private val retrofit: Retrofit = createNetworkClient(BASE_URL, true)

private val userApiService: UserRepositoryService =
    retrofit.create(UserRepositoryService::class.java)