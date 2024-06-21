package com.example.submission1githubuser.ui.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.submission1githubuser.data.response.GithubUser
import com.example.submission1githubuser.R
import com.example.submission1githubuser.adapter.PagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.example.submission1githubuser.databinding.ActivityDetailBinding
import com.example.submission1githubuser.model.DetailViewModel
import com.example.submission1githubuser.model.FavoriteViewModelFactory

class DetailActivity : AppCompatActivity() {

/*  1. Penggunaan lateinit digunakan untuk menginisiasi tanpa mendekalrasikan value
    2. Lateinit harus bertipe var
    3. Tidak boleh mereturn tipe data primitif (Int,Double,Dll)
    4. Harus mereturn bertipe object (String,List,DLL)
    */
    private lateinit var binding: ActivityDetailBinding
    private lateinit var detailViewModel: DetailViewModel
    private lateinit var username: String
    private var isFavorite: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

//      Action Bar Setting
        supportActionBar?.title = "User Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        detailViewModel = obtainViewModel(this)

        val user = intent.getParcelableExtra<GithubUser>(EXTRA_USER) as GithubUser
        detailViewModel.setUserLogin(user.login)

        username = user.login
        supportActionBar?.title = username


        detailViewModel.datauser.observe(this) { user ->
            with(binding) {
                nameView.text = user.name
                countRepoView.text = user.publicRepos
                urlUser.text = user.htmlUrl ?: " - "
                countFollowersView.text = user.followers
                countFollowingView.text = user.following
                Glide.with(this@DetailActivity)
                    .load(user.avatarUrl)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(imgAvatar)
            }
        }

        detailViewModel.isLoading.observe(this) { isLoading ->
            with(binding) {
                progressBar2.visibility = if (isLoading) View.VISIBLE else View.GONE
                if (isLoading) {
                    nameView.text = ""
                    countRepoView.text = ""
                    urlUser.text = ""
                    countFollowersView.text = ""
                    countFollowingView.text = ""
                    Glide.with(this@DetailActivity)
                        .load(R.drawable.ic_launcher_foreground)
                        .into(imgAvatar)
                }
            }
        }


        //      Pemanggilan PagerAdapter
        val pagerAdapter = PagerAdapter(this)
        binding.viewPager.adapter = pagerAdapter
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

//      Membuat Proses Penyimpanan Clickable Floating Button
        binding.btnFavorite.setOnClickListener {
            if (isFavorite) {
                detailViewModel.deleteDataUser(user)
                Toast.makeText(this, R.string.favorite_remove, Toast.LENGTH_SHORT).show()
            } else {
                detailViewModel.insertDataUser(user)
                Toast.makeText(this, R.string.favorite_add, Toast.LENGTH_SHORT).show()
            }
            isFavorite = !isFavorite
            updateFavoriteButtonUI()
        }

//      Melakukan Proses Update View UI
        detailViewModel.getAllUsers().observe(this) {
            isFavorite = it.contains(user)
            updateFavoriteButtonUI()
        }

    }

    //    Berfungsi Untuk Melakukan Update Icon
    fun updateFavoriteButtonUI() {
        this.isFavorite = isFavorite
        if (isFavorite) {
            binding.btnFavorite.setImageResource(R.drawable.ic_favorite_red_24)
        } else {
            binding.btnFavorite.setImageResource(R.drawable.ic_favorite_border)
        }
    }

    companion object {
        const val EXTRA_USER = "extra_user"
        const val EXTRA_AVATAR = "extra_avatar"
        const val EXTRA_URL = "extra_url"

        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2
        )
    }



    //   Berfungsi Untuk Menyalakan Fungsi Anak Panah Ke Home
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun obtainViewModel(activity: AppCompatActivity): DetailViewModel {
        val factory = FavoriteViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory)[DetailViewModel::class.java]
    }

//  Membuat Menu Option
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search_detail_menu, menu)
        return true
    }

//  Membuat Selected Menu Option
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.favorite -> {
                val intent = Intent(this@DetailActivity, FavoriteActivity::class.java)
                startActivity(intent)
                true
            }

            R.id.darktheme -> {
                val intent = Intent(this@DetailActivity, DarkThemeActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.share -> {
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(
                        Intent.EXTRA_TEXT,
                        "https://github.com/${username}"
                    )
                    type = "text/plain"
                }
                val openShareProfile = Intent.createChooser(sendIntent, null)
                startActivity(openShareProfile)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}