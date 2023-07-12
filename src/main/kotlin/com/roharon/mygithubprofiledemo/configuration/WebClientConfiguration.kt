package com.roharon.mygithubprofiledemo.configuration

import com.roharon.mygithubprofiledemo.datasource.GithubClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.support.WebClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory
import org.springframework.web.service.invoker.createClient

@Configuration
class WebClientConfiguration {

    @Bean
    fun webClient(): WebClient {
        return WebClient.create()
    }

    @Bean
    fun githubClient(
        @Value("\${github.api.url}") githubApiUrl: String
    ): GithubClient {
        return HttpServiceProxyFactory.builder(
            WebClientAdapter.forClient(
                webClient().mutate().baseUrl(githubApiUrl)
                    .defaultHeader("Accept", "application/vnd.github+json")
                    .defaultHeader("X-GitHub-Api-Version", "2022-11-28")
                    .build()
            )
        ).build().createClient()
    }
}
