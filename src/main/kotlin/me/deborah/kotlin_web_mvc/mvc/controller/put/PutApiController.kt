package me.deborah.kotlin_web_mvc.mvc.controller.put

import me.deborah.kotlin_web_mvc.mvc.model.http.Result
import me.deborah.kotlin_web_mvc.mvc.model.http.UserRequest
import me.deborah.kotlin_web_mvc.mvc.model.http.UserResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class PutApiController {
    @PutMapping("/put-mapping")
    fun putMapping(): String {
        return "put-mapping"
    }

    @RequestMapping(method = [RequestMethod.PUT], path = ["request-mapping"])
    fun requestMapping(): String {
        return "request-mapping - put method"
    }

    // put은 request요청이 오면 없으면 생성하고 이미 있으면 수정을 한다.
    @PutMapping(path = ["put-mapping/obejct"])
    fun putMappingObejct (@RequestBody userRequest: UserRequest): UserResponse {

        println(userRequest)
        // 0. Response
        return UserResponse().apply {

            // 1. result
            this.result = Result().apply {
                this.resultCode = "OK"
                this.resultMessage = "성공"
            }
        }.apply {
            // 2. description
            this.description = "blaahh"
        }.apply {
            // 3. user mutable list
            val userList = mutableListOf<UserRequest>()
            userList.add(userRequest)
            userList.add(UserRequest().apply {
                this.name = "a"
                this.age = 10
                this.email = "ddfd@gmail.com"
                this.address = "seoul"
                this. phoneNumber = "010-2222-2222"
            })
            userList.add(UserRequest().apply {
                this.name = "b"
                this.age = 20
                this.email = "dbbbb@gmail.com"
                this.address = "busan"
                this. phoneNumber = "010-1111-2122"
            })

            this.userRequest = userList
        }
    }
}