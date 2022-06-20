package com.example.mvc.domain

import com.example.mvc.validator.StringFormatDateTime
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import javax.validation.constraints.*
import kotlin.math.min

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class UserRequest (

    @field:NotNull(message = "이름은 필수 값입니다.")
    @field:Size(min = 2, max = 8)
    var name:String?=null,

    @field:PositiveOrZero
    var age:Int?=null,

    @field:Email
    var email:String?=null,

    @field:NotBlank
    var address:String?=null,

    var phoneNumber:String?=null,

    @field:StringFormatDateTime(patten = "yyyy-MM-dd HH:mm:ss", message = "패턴이 올바르지 않습니다.")
    var createdAt:String?= null
)


