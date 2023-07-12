package com.roharon.mygithubprofiledemo.controller

import jakarta.servlet.http.HttpServletRequest
import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ExceptionHandlingController : ErrorController {

    @GetMapping("/error")
    fun handleError(request: HttpServletRequest, model: Model): String {
        return "error"
    }
}
