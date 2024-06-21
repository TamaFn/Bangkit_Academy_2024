package com.example.submission1githubuser.ui

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission1githubuser.data.response.GithubUser
import com.example.submission1githubuser.R
import com.example.submission1githubuser.adapter.UsersAdapter
import com.example.submission1githubuser.databinding.ActivityMainBinding
import com.example.submission1githubuser.model.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    private var dataUser = listOf<GithubUser>()

    companion object {
        const val TAG = "MainActivity"
        const val APICode = "token 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"
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        with(binding) {
            searchView.setupWithSearchBar(SearchBar)
            searchView
                .editText
                .setOnEditorActionListener { _, _, _ ->
                    val query = binding.searchView.text.toString()
                    mainViewModel.getDataUserSearch(query)
//                    SearchBar.text = searchView.text
                    binding.searchView.hide()
                    true
                }
            SearchBar.inflateMenu(R.menu.search)
            SearchBar.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.about -> {
                        val intent = Intent(this@MainActivity, InfoActivity::class.java)
                        startActivity(intent)
                        true
                    }

                    R.id.favorite -> {
                        val intent = Intent(this@MainActivity, FavoriteActivity::class.java)
                        startActivity(intent)
                        true
                    }

                    R.id.darktheme -> {
                        val intent = Intent(this@MainActivity, DarkThemeActivity::class.java)
                        startActivity(intent)
                        true
                    }
                    else -> false
                }
                true
            }
        }


        val layoutManager = LinearLayoutManager(this)
        binding.rvAdapter.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.rvAdapter.addItemDecoration(itemDecoration)

        mainViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(MainViewModel::class.java)

        mainViewModel.user.observe(this) { user ->
            dataUser = user
            setListData(user)
        }

        mainViewModel.isLoading.observe(this) {
            showLoading(it)
        }

        mainViewModel.listUser.observe(this@MainActivity) { listUser ->
            setListData(listUser)
        }

    }

    private fun setListData(githubList: List<GithubUser>) {
        binding.userNoneNotice.visibility = if (githubList.isEmpty()) View.VISIBLE else View.GONE
        val adapter = UsersAdapter(githubList)
        binding.rvAdapter.adapter = adapter
        adapter.setOnItemClickCallback(object : UsersAdapter.OnItemClickCallback {
            override fun onItemClicked(data: GithubUser) {
                sendSelectedUser(data)
            }
        })
    }
//
    private fun sendSelectedUser(data: GithubUser) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_USER, data)
        startActivity(intent)
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.about -> {
                val intent = Intent(this@MainActivity, InfoActivity::class.java)
                startActivity(intent)
                true
            }

            R.id.favorite -> {
                val intent = Intent(this@MainActivity, FavoriteActivity::class.java)
                startActivity(intent)
                true
            }

            R.id.darktheme -> {
                val intent = Intent(this@MainActivity, DarkThemeActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }




}