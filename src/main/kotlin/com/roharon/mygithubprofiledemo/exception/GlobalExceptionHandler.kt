package com.roharon.mygithubprofiledemo.exception

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(value = [GithubApiException::class])
    fun handleGithubApiException(ex: GithubApiException): String {
        return "login"
    }
}
