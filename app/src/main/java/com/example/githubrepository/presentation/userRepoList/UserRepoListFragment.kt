package com.example.githubrepository.presentation.userRepoList

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.githubrelopository.presentation.base.extension.visible
import com.example.githubrepository.R
import com.example.githubrepository.databinding.FragmentUserRepoListBinding
import com.example.githubrepository.presentation.base.delegate.viewBinding
import com.example.githubrepository.presentation.base.extension.observe
import com.example.githubrepository.presentation.base.extension.toast
import com.example.githubrepository.presentation.base.ui.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserRepoListFragment : BaseFragment(R.layout.fragment_user_repo_list) {

    private val binding: FragmentUserRepoListBinding by viewBinding()

    private val viewModel: UserRepositoryViewModel by viewModel()

    private val userRepoListAdapter = UserRepoListAdapter()

    private val stateObserver = Observer<UserRepositoryViewModel.ViewState> {
        userRepoListAdapter.userRepos = it.userRepos
        binding.progressBar.visible = it.isLoading
        binding.errorAnimation.visible = it.isError
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUI()
    }

    private fun initUI() {
        userRepoListAdapter.setOnDebouncedClickListener {
            requireContext().toast(R.string.owner_name)
        }
        binding.recyclerView.apply {
            setHasFixedSize(true)
            adapter = userRepoListAdapter
        }
        observe(viewModel.stateLiveData, stateObserver)
        viewModel.loadData()
    }
}