package me.deborah.kotlin_web_mvc.mvc.controller.post

import me.deborah.kotlin_web_mvc.mvc.model.http.UserRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class PostApiController {

    @PostMapping("/post-mapping")
    fun postMapping(): String {
        return "post-mapping"
    }

    // 충돌이 나지 않는다, 받는 형식이 달라서
    // POST / GET 달라서... 그러나 되도록 겹치지 않도록.
    @RequestMapping(method = [RequestMethod.POST], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping"
    }

    // ojbect mapper
    // json     ->  object
    // obejct   ->  json

    @PostMapping("/post-mapping/obejct")
    fun postMappingObejct(@RequestBody userRequest: UserRequest): UserRequest {
        // json-> object
        println(userRequest)
        return userRequest
    }
}
