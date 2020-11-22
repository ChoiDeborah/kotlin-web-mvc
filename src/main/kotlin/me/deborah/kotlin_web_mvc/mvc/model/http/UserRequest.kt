package me.deborah.kotlin_web_mvc.mvc.model.http

// RestController인 경우
// Obejct일 때, Json형태로 바뀐다.
data class UserRequest (
    var name : String?=null,
    var age : Int?=null,
    var email : String?=null,
    var address : String?= null
)