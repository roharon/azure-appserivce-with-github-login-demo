package com.roharon.mygithubprofiledemo.profile.service

import com.roharon.mygithubprofiledemo.client.GithubClient
import com.roharon.mygithubprofiledemo.client.GithubUserResponse
import org.springframework.stereotype.Service

@Service
class GithubService(private val githubClient: GithubClient) {

    fun getUser(token: String): GithubUserResponse {
        println("token: ${authorizationHeader(token)}")
        return githubClient.getUser(authorizationHeader(token))
    }

    companion object {
        fun authorizationHeader(token: String) = "Bearer $token"
    }
}
