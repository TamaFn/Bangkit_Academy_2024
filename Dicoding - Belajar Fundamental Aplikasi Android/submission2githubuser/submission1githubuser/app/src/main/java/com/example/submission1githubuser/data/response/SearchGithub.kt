package com.example.submission1githubuser.data.response

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
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

@Entity
@Parcelize
data class GithubUser(

	@PrimaryKey
	@field:SerializedName("login")
	@ColumnInfo("login")
	val login: String,  // Provide a non-null default value or remove the annotation

	@ColumnInfo("avatar_url")
	@field:SerializedName("avatar_url")
	val avatarUrl: String? = null,

	@ColumnInfo
	@field:SerializedName("html_url")
	val htmlUrl: String? = null
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
	var avatarUrl: String,

	@field:SerializedName("site_admin")
	val siteAdmin: Boolean? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("gravatar_id")
	val gravatarId: String? = null,

	@field:SerializedName("node_id")
	val nodeId: String? = null,

	@field:SerializedName("organizations_url")
	val organizationsUrl: String? = null


)
