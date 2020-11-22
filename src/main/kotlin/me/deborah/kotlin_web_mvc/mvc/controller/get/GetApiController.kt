package me.deborah.kotlin_web_mvc.mvc.controller.get

import me.deborah.kotlin_web_mvc.mvc.model.http.UserRequest
import org.springframework.web.bind.annotation.*

@RestController //REST API Contoller 동작
@RequestMapping("/api")
class GetApiController {

    @GetMapping(path = ["/hello", "/abcd"])
    fun hello() : String {
        return "hello kotlin"
    }

    // Stirng array []
    @RequestMapping(method = [RequestMethod.GET], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping"
    }

    @GetMapping("/get-mapping/path-variable/{name}/{age}")
    fun pathVarialbe(@PathVariable name: String, @PathVariable age:Int): String {
        println("${name}, ${age}")
        return name + " " +age
    }


    @GetMapping("/get-mapping/path-variable2/{name}/{age}")
    fun pathVarialbe2(@PathVariable(value = "name") _name: String, @PathVariable(name = "age") age:Int): String {
        println("${_name}, ${age}")
        return _name + " " +age
    }

    // 쿼리파라미터는 어떻게 받는가?
    @GetMapping("get-mapping/query-param")
    fun queryParam(
            @RequestParam(name = "name") name: String,
            @RequestParam(value = "age") age:Int
    ) : String {
        println("$name, $age")
        return name+" " + age
    }

    // 인자를 하나하나 받기 귀찮으니 객체로 맵핑 하는 법?
    // phoneNumber -> uri 설계시 쿼리 파라미터에서는 소문자 를 쓴다.... 변수에 하이픈이 들어갈 수 없음
    // RequestParam에 name을 명시적으로 바꿔줘야함.
    @GetMapping("get-mapping/query-param/")
    fun queryParamObject(userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest
    }

    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(@RequestParam map: Map<String, Any>): Map<String, Any> {
        println(map)
        val phoneNum = map.get("phone-number");
        return map
    }
}