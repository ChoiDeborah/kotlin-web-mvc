package me.deborah.kotlin_web_mvc.mvc.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

// RestController인 경우
// Obejct일 때, Json형태로 바뀐다.

//// 방법 2: 클래스에 타입을 지정해주는 방법
//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class UserRequest (
    var name : String?=null,
    var age : Int?=null,
    var email : String?=null,
    var address : String?= null,
    // 방법 1
    //@JsonProperty("phone_number")   // 리턴의 형태도 phone_number로 변함.
    var phoneNumber : String?= null       // phone_number (Json은 보통 snake case)
)

// 방법 3 : ObejctMapper를 Bean으로 등록할 때 네이밍을 설정하거나
// 방법 4 : 스프링 부트 설정에서 네이밍 규칙을 설정하거나
// 근데 보통 1, 2가 많이 쓰임.