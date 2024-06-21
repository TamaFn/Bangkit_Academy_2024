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
import com.example.submission1githubuser.databinding.FragmentFollowersBinding
import com.example.submission1githubuser.model.DetailViewModel
import com.example.submission1githubuser.ui.Activity.DetailActivity

class FollowersFragment : Fragment() {

    private lateinit var binding: FragmentFollowersBinding
    private val detailViewModel: DetailViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFollowersBinding.inflate(inflater, container, false)

//      Deklarasi Layout Manager
        val layoutManager = LinearLayoutManager(context)
        binding.rvFollowers.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(context, layoutManager.orientation)
        binding.rvFollowers.addItemDecoration(itemDecoration)

//        val detailViewModel = ViewModelProvider(requireActivity())[DetailViewModel::class.java]

        detailViewModel.userfollowers.observe(viewLifecycleOwner) {
            setUserFollowerData(it)
        }

        detailViewModel.isLoadingUserFollower.observe(viewLifecycleOwner) {
            showLoading(it)
        }


        return binding.root
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.followersNone.visibility = View.GONE
            binding.progressBarFollower.visibility = View.VISIBLE
            binding.rvFollowers.alpha = 0.0F
        } else {
            binding.progressBarFollower.visibility = View.GONE
            binding.rvFollowers.alpha = 1F
        }
    }

    private fun setUserFollowerData(user: List<GithubUser>) {
        binding.followersNone.visibility = if (user.isEmpty()) View.VISIBLE else View.GONE
        binding.rvFollowers.apply {
            binding.rvFollowers.layoutManager = LinearLayoutManager(context)
            val listUserAdapter = UsersAdapter(user)
            binding.rvFollowers.adapter = listUserAdapter

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