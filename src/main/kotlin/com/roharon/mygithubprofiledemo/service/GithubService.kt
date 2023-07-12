package com.roharon.mygithubprofiledemo.service

import com.roharon.mygithubprofiledemo.datasource.GithubClient
import com.roharon.mygithubprofiledemo.datasource.model.GithubUserResponse
import com.roharon.mygithubprofiledemo.exception.GithubApiException
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClientResponseException

@Service
class GithubService(private val githubClient: GithubClient) {

    fun getUser(token: String): GithubUserResponse {
        try {
            return githubClient.getUser(authorizationHeader(token))
        } catch (ex: WebClientResponseException) {
            throw GithubApiException()
        }
    }

    companion object {
        fun authorizationHeader(token: String) = "Bearer $token"
    }
}
