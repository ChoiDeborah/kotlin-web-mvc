package me.deborah.kotlin_web_mvc.mvc.controller.response

import me.deborah.kotlin_web_mvc.mvc.model.http.UserRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/response")
class ResponseApiController {
    // 1. get 4XX
    // GET http://localhose:8080/api/response
    @GetMapping("/response/get-mapping")
    fun GetMapping(@RequestParam(required = true) age:Int?): ResponseEntity<String> {
        return age?.let {
            if (age < 20) {
                return ResponseEntity.status(400).body("age는 20보다 커야한다!")
            }

            ResponseEntity.ok("OK")
        } ?: kotlin.run {
            return ResponseEntity.status(400).body("age가 비정상입니다!")

        }

        /*
        // Int? <- nullable하다.
        // 1. age == null -> 400 Error

        if(null == age){
            return ResponseEntity.status(400).body("age가 비정상입니다!")
        }
        // 2. age < 20 -> 400 Error
        if(age < 20){
            return ResponseEntity.status(400).body("age는 20보다 커야한다!")
        }

        return ResponseEntity.ok("OK")
         */
    }

    // 2. post 200
    @PostMapping("")
    fun postMapping(@RequestBody userRequest: UserRequest?): ResponseEntity<Any> {
        return ResponseEntity.status(200).body(userRequest) // obejct mapper : object -> json
    }

    // 3. put 201
    @PutMapping("")
    fun putMapping(@RequestBody userRequest: UserRequest?): ResponseEntity<UserRequest> {
        // 1. 기존 데이터가 없어서 새로 생성했다.
        return ResponseEntity.status(HttpStatus.CREATED).body(userRequest)
    }

    // 4. delete 500
    @DeleteMapping("/{id}")
    fun deleteMapping(@PathVariable id:Int): ResponseEntity<Any> {
        return ResponseEntity.status(500).body(null)
    }
}