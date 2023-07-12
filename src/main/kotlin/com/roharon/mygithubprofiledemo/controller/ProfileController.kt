package com.roharon.mygithubprofiledemo.controller

import com.roharon.mygithubprofiledemo.datasource.model.GithubUserResponse
import com.roharon.mygithubprofiledemo.service.GithubService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ProfileController(private val githubService: GithubService) {

    @GetMapping("/")
    fun profile(model: Model, @CookieValue("githubToken") githubToken: String?): String {
        if (githubToken == null) {
            return "redirect:preview-profile"
        }

        val user: GithubUserResponse = githubService.getUser(githubToken)

        model["githubUserName"] = user.name ?: ""
        model["githubProfileImageUrl"] = user.avatarUrl
        model["bio"] = user.bio ?: ""
        model["email"] = user.email ?: ""
        model["blog"] = user.blog ?: ""

        return "profile"
    }

    @GetMapping("/login")
    fun login(model: Model): String {
        return "login"
    }

    @GetMapping("/preview-profile")
    fun preview(model: Model): String {
        return "preview-profile"
    }
}
