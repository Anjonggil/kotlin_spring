package com.example.mvc.controller

import com.example.mvc.domain.UserRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class GetApiController {

    @GetMapping("/hello")
    fun hello(): String{
        return "hello kotlin"
    }

    @RequestMapping(method = [RequestMethod.GET], path = ["request-mapping"])
    fun requestMapping(): String{
        return "request-mapping"
    }

    @GetMapping("/get-mapping/path-variable/{name}/{age}")
    fun pathVariable(
        @PathVariable(value = "name") _name: String,
        @PathVariable(value = "age") _age:Int): String{

        println("name = $_name")
        return "$_name $_age"
    }

    @GetMapping("/query-param")
    fun queryParam(
        @RequestParam name:String,
        @RequestParam age:Int
    ): String{
        return "$name $age"
    }

    @GetMapping("/query-param/object")
    fun queryParamObject(userRequest: UserRequest) : UserRequest{
        return userRequest
    }

}