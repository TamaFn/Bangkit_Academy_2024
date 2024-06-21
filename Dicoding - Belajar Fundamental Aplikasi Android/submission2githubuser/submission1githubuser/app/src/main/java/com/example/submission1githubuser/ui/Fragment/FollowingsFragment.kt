package com.example.submission1githubuser.ui.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission1githubuser.data.response.GithubUser
import com.example.submission1githubuser.adapter.UsersAdapter
import com.example.submission1githubuser.databinding.FragmentFollowingsBinding
import com.example.submission1githubuser.model.DetailViewModel

class FollowingsFragment : Fragment() {

    private lateinit var binding: FragmentFollowingsBinding
    private val detailViewModel: DetailViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFollowingsBinding.inflate(inflater, container, false)

        val layoutManager = LinearLayoutManager(context)
        binding.rvFollowings.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(context, layoutManager.orientation)
        binding.rvFollowings.addItemDecoration(itemDecoration)

//        val detailViewModel = ViewModelProvider(requireActivity())[DetailViewModel::class.java]

        detailViewModel.userfollowings.observe(viewLifecycleOwner) {
            setUserFollowingData(it)
        }

        detailViewModel.isLoadingUserFollowing.observe(viewLifecycleOwner) {
            showLoading(it)
        }

        return binding.root
    }


    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.followingNone.visibility = View.GONE
            binding.progressBarFollowing.visibility = View.VISIBLE
            binding.rvFollowings.alpha = 0.0F
        } else {
            binding.progressBarFollowing.visibility = View.GONE
            binding.rvFollowings.alpha = 1F
        }
    }

    private fun setUserFollowingData(user: List<GithubUser>) {
        binding.followingNone.visibility = if (user.isEmpty()) View.VISIBLE else View.GONE
        binding.rvFollowings.apply {
            binding.rvFollowings.layoutManager = LinearLayoutManager(context)
            val listUserAdapter = UsersAdapter(user)
            binding.rvFollowings.adapter = listUserAdapter

            listUserAdapter.setOnItemClickCallback(object : UsersAdapter.OnItemClickCallback {
                override fun onItemClicked(data: GithubUser) {
                    val detailViewModel =
                        ViewModelProvider(requireActivity())[DetailViewModel::class.java]
                    detailViewModel.setUserLogin(data.login.toString())
                }
            })
        }
    }
}