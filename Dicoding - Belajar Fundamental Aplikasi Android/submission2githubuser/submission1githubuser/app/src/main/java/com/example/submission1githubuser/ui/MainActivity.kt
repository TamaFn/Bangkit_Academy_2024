package com.example.submission1githubuser.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission1githubuser.Preferences.SettingPreferences
import com.example.submission1githubuser.Preferences.dataStore
import com.example.submission1githubuser.data.response.GithubUser
import com.example.submission1githubuser.R
import com.example.submission1githubuser.adapter.UsersAdapter
import com.example.submission1githubuser.databinding.ActivityMainBinding
import com.example.submission1githubuser.model.DarkThemeViewModel
import com.example.submission1githubuser.model.MainViewModel
import com.example.submission1githubuser.ui.Activity.DarkThemeActivity
import com.example.submission1githubuser.ui.Activity.DetailActivity
import com.example.submission1githubuser.ui.Activity.FavoriteActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var darkViewModel: DarkThemeViewModel
    private lateinit var adapter : UsersAdapter
    private var userdata = listOf<GithubUser>()

    companion object {
        const val TAG = "MainActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//      Memanggil binding dari id ActivityMain.xml
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//      Menhide ActionBar
        supportActionBar?.hide()

//      Membuat Search Bar and Search View
        with(binding) {
            searchView.setupWithSearchBar(SearchBar)
            searchView
                .editText
                .setOnEditorActionListener { _, _, _ ->
                    val query = binding.searchView.text.toString()
                    mainViewModel.getDataSearch(query)
//                    SearchBar.text = searchView.text
                    binding.searchView.hide()
                    true
                }
            SearchBar.inflateMenu(R.menu.search)
            SearchBar.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
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

//      Mengatur Layout Manager dan Pemanggilan Adapter
        val layoutManager = LinearLayoutManager(this)
        binding.rvAdapter.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.rvAdapter.addItemDecoration(itemDecoration)

//      Menghubungkan Main Activity dengan MainViewModel
        mainViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()).get(MainViewModel::class.java)

        mainViewModel.user.observe(this) { user ->
            if (user != null) {
                userdata = user
                binding.userNoneNotice.visibility = if (user.isEmpty()) View.VISIBLE else View.GONE
                adapter = UsersAdapter(user)
                binding.rvAdapter.adapter = adapter
                adapter.setOnItemClickCallback(object : UsersAdapter.OnItemClickCallback {
                    override fun onItemClicked(data: GithubUser) {
                        val intent = Intent(this@MainActivity, DetailActivity::class.java)
                        intent.putExtra(DetailActivity.EXTRA_USER, data)
                        startActivity(intent)
                    }
                })
            }
        }

        mainViewModel.isLoading.observe(this@MainActivity) {
            showLoading(it)
        }


        val modePreferences = SettingPreferences.getInstance(dataStore)
        val modeViewModel = ViewModelProvider(
            this,
            DarkThemeViewModel.DarkThemeViewModelFactory(modePreferences)
        )[DarkThemeViewModel::class.java]

        modeViewModel.getThemeSettings().observe(this) { isDarkModeActive: Boolean ->
            if (isDarkModeActive) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }



        mainViewModel.listUser.observe(this@MainActivity) { listUser ->
            binding.userNoneNotice.visibility = if (listUser.isEmpty()) View.VISIBLE else View.GONE
            adapter = UsersAdapter(listUser)
            binding.rvAdapter.adapter = adapter
            adapter.setOnItemClickCallback(object : UsersAdapter.OnItemClickCallback {
                override fun onItemClicked(data: GithubUser) {
                    val intent = Intent(this@MainActivity, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_USER, data)
                    startActivity(intent)
                }
            })
        }
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
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