package com.roharon.mygithubprofiledemo.datasource

import com.roharon.mygithubprofiledemo.datasource.model.GithubUserResponse
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.service.annotation.GetExchange

interface GithubClient {
    @GetExchange("/user")
    fun getUser(
        @RequestHeader("Authorization") userAuthorization: String
    ): GithubUserResponse
}
