package me.deborah.kotlin_web_mvc.mvc.controller.get

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController //REST API Contoller 동작
@RequestMapping("/api")
class GetApiController {

    @GetMapping("/hello")
    fun hello() : String {
        return "hello kotlin"
    }
}