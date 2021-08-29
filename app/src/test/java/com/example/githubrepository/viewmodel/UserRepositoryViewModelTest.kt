package com.example.githubrepository.viewmodel

import com.example.githubrepository.CoroutinesTestRule
import com.example.githubrepository.domain.usecase.GetUserRepoUseCase
import com.example.githubrepository.news
import com.example.githubrepository.presentation.userRepoList.UserRepositoryViewModel
import com.nhaarman.mockitokotlin2.mock
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

/**
 * Created by SangiliPandian C on 16-06-2019.
 */

class UserRepositoryViewModelTest {

    private lateinit var viewModel: UserRepositoryViewModel

    private val mockRepo: GetUserRepoUseCase = mock()

    private val newsList = listOf(news)

    // Set the main coroutines dispatcher for unit testing.
    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    // Executes each task synchronously using Architecture Components.
    /*@get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
*/
    @Before
    fun setUp() {
        viewModel = UserRepositoryViewModel(mockRepo)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun refreshNewsFeed() = coroutinesTestRule.testDispatcher.runBlockingTest {
        viewModel = UserRepositoryViewModel(mockRepo).also {
            it.loadData()
        }
        Mockito.verify(mockRepo).execute()
    }
}