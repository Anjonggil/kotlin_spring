package com.example.mvc.controller

import com.example.mvc.domain.UserRequest
import com.example.mvc.domain.UserResponse
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PutApiController {

    @PutMapping("/put-mapping")
    fun putMapping():String{
        return "put-mapping"
    }

    @PutMapping("/put-mapping/object")
    fun putMappingObject(@RequestBody userRequest: UserRequest):UserResponse{
        return UserResponse().apply {
            this.result = com.example.mvc.domain.Result().apply {
                this.resultCode = "ok"
                this.resultMessage = "성공"
            }
        }.apply {
            this.description = "------------"
        }.apply {
            val userList = mutableListOf<UserRequest>()

            userList.add(userRequest)

            userList.add(UserRequest().apply {
                this.name = "a"
                this.age = 10
                this.email = "a@gmail.com"
                this.address ="a address"
                this.phoneNumber = "010-1111-1111"
            })

            this.userRequest = userList
        }
    }
}