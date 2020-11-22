package me.deborah.kotlin_web_mvc.mvc.controller.page

import me.deborah.kotlin_web_mvc.mvc.model.http.UserRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class PageController {

    // http://localhost/8080/main
    @GetMapping("/main")
    fun main(): String {
        println("init main")
        return "main.html"
    }

    // 컨트롤러 페이지 관련 컨트롤러에서 뷰가 따로 보여질 필요가 없을 때...
    @ResponseBody
    @GetMapping("/test")
    fun response(): UserRequest {
        // response Body  없을 떄 -> 500 Error
        return UserRequest().apply {
            this.name = "steve"
        }
        //return "main.html"
    }
}