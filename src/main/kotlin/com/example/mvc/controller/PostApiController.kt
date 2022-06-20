package com.example.mvc.controller

import com.example.mvc.domain.UserRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class PostApiController {


    @PostMapping("/post-mapping")
    fun postMapping(): String{
        return "post-mapping"
    }

    @PostMapping("/post-mapping/object")
    fun postMappingObject(@Valid @RequestBody userRequest: UserRequest):UserRequest{
        return userRequest
    }
}