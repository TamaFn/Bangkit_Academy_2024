package com.example.submission1githubuser.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submission1githubuser.data.response.GithubUser
import com.example.submission1githubuser.R

class UsersAdapter(private val listUsers: List<GithubUser>) :
    RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(callback: OnItemClickCallback) {
        this.onItemClickCallback = callback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: GithubUser)
    }

    override fun getItemCount(): Int = listUsers.size

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(viewGroup.context).inflate(R.layout.item_users, viewGroup, false)
    )

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val user = listUsers[position]
        viewHolder.usernameTextView.text = user.login
        viewHolder.profileUrlTextView.text = user.htmlUrl
        Glide.with(viewHolder.avatarImageView.context)
            .load(user.avatarUrl)
            .into(viewHolder.avatarImageView)

        // Set click listener
        viewHolder.itemView.setOnClickListener {
            onItemClickCallback?.onItemClicked(user)
        }
    }


    inner class ViewHolder(private var view: View) : RecyclerView.ViewHolder(view) {
        val usernameTextView: TextView = view.findViewById(R.id.usernameTextView)
        val avatarImageView: ImageView = view.findViewById(R.id.avatarImageView)
        val profileUrlTextView: TextView = view.findViewById(R.id.profileUrlTextView)
    }

}

