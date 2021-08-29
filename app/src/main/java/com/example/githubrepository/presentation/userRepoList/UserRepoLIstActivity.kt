package com.example.githubrepository.presentation.userRepoList

import android.os.Bundle
import com.example.githubrepository.R
import com.example.githubrepository.di.injectModules
import com.example.githubrepository.presentation.base.extension.replaceFragment
import com.example.githubrepository.presentation.base.ui.BaseActivity

class UserRepoLIstActivity : BaseActivity() {

    private val mTAG = UserRepoLIstActivity::class.java.canonicalName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectModules()
        setContentView(R.layout.activity_main)
        initUI()
    }

    private fun initUI() {
        displayFragment()
    }

    private fun displayFragment() {
        replaceFragment(UserRepoListFragment(), mTAG, true, R.id.flUserRepo)
    }
}