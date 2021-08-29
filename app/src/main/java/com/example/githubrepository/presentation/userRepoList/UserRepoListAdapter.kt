package com.example.githubrepository.presentation.userRepoList


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubrepository.databinding.ItemUserRepoListBinding
import com.example.githubrepository.domain.model.UserRepo
import com.example.githubrepository.helper.formatUtcToDate
import com.example.githubrepository.presentation.base.delegate.observer

@SuppressLint("NotifyDataSetChanged")
internal class UserRepoListAdapter : RecyclerView.Adapter<UserRepoListAdapter.ViewHolder>() {

    var userRepos: List<UserRepo> by observer(listOf()) {
        notifyDataSetChanged()
    }

    private var onDebouncedClickListener: ((userRepo: UserRepo) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemUserRepoListBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(userRepos[position])
    }

    override fun getItemCount(): Int = userRepos.size

    fun setOnDebouncedClickListener(listener: (userRepo: UserRepo) -> Unit) {
        this.onDebouncedClickListener = listener
    }

    internal inner class ViewHolder(private val binding: ItemUserRepoListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(userRepo: UserRepo) {
            binding.name.text = userRepo.name
            binding.description.text = userRepo.description
            binding.createdAt.text = formatUtcToDate(userRepo.createdAt)
        }
    }
}
