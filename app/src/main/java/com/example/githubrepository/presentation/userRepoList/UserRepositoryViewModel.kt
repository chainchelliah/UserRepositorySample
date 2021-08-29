package com.example.githubrepository.presentation.userRepoList

import androidx.lifecycle.viewModelScope
import com.example.githubrepository.domain.model.UserRepo
import com.example.githubrepository.domain.usecase.GetUserRepoUseCase
import com.example.githubrepository.presentation.base.ui.viewmodel.BaseAction
import com.example.githubrepository.presentation.base.ui.viewmodel.BaseViewModel
import com.example.githubrepository.presentation.base.ui.viewmodel.BaseViewState
import kotlinx.coroutines.launch

internal class UserRepositoryViewModel(
    private val getUserRepoUseCase: GetUserRepoUseCase
) : BaseViewModel<UserRepositoryViewModel.ViewState, UserRepositoryViewModel.Action>(ViewState()) {

    override fun onLoadData() {
        getUserRepoList()
    }

    override fun onReduceState(viewAction: Action) = when (viewAction) {
        is Action.UserRepoListLoadingSuccess -> state.copy(
            isLoading = false,
            isError = false,
            userRepos = viewAction.userRepos
        )
        is Action.UserRepoListLoadingFailure -> state.copy(
            isLoading = false,
            isError = true,
            userRepos = listOf()
        )
    }

    private fun getUserRepoList() {
        viewModelScope.launch {
            getUserRepoUseCase.execute().also { result ->
                val action = when (result) {
                    is GetUserRepoUseCase.Result.Success ->
                        if (result.data.isEmpty()) {
                            Action.UserRepoListLoadingFailure
                        } else {
                            Action.UserRepoListLoadingSuccess(result.data)
                        }

                    is GetUserRepoUseCase.Result.Error ->
                        Action.UserRepoListLoadingFailure
                }
                sendAction(action)
            }
        }
    }

    internal data class ViewState(
        val isLoading: Boolean = true,
        val isError: Boolean = false,
        val userRepos: List<UserRepo> = listOf()
    ) : BaseViewState

    internal sealed interface Action : BaseAction {
        class UserRepoListLoadingSuccess(val userRepos: List<UserRepo>) : Action
        object UserRepoListLoadingFailure : Action
    }
}
