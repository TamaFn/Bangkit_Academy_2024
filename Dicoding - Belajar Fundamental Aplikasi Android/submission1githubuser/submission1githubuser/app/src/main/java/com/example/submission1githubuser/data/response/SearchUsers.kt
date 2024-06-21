package com.example.submission1githubuser.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class SearchUsers(

	@field:SerializedName("total_count")
	val totalCount: Int? = null,

	@field:SerializedName("incomplete_results")
	val incompleteResults: Boolean? = null,

	@field:SerializedName("items")
	val items: List<GithubUser>
)

@Parcelize
data class GithubUser(

	@field:SerializedName("login")
	val login: String? = null,

	@field:SerializedName("avatar_url")
	val avatarUrl: String? = null,

	@field:SerializedName("html_url")
	val htmlUrl: String? = null,

	) : Parcelable

data class DetailUser(

	@field:SerializedName("login")
	val login: String,

	@field:SerializedName("name")
	var name: String,

	@SerializedName("html_url")
	var htmlUrl: String?,

	@SerializedName("public_repos")
	var publicRepos: String,

	@field:SerializedName("followers")
	var followers: String,

	@field:SerializedName("following")
	var following: String,

	@SerializedName("avatar_url")
	var avatarUrl: String
)
