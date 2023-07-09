package com.roharon.mygithubprofiledemo.client

import com.fasterxml.jackson.annotation.JsonProperty

data class GithubUserResponse(
    val id: Long,
    @JsonProperty("avatar_url")
    val avatarUrl: String,
    @JsonProperty("html_url")
    val htmlUrl: String,
    val name: String?,
    val email: String?,
    val bio: String?,
    val followers: Long,
    val following: Long,
    val location: String?,
    val blog: String?,
)
