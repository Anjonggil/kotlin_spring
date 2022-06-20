package com.example.mvc.controller

import com.example.mvc.domain.UserRequest
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
@AutoConfigureMockMvc
internal class PostApiControllerTest{

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun postTest(){
        val userRequest = UserRequest().apply {
            this.name = "giri"
            this.age = 10
            this.phoneNumber = "010-1111-2222"
            this.address = "서울시 관악구"
            this.email = "qws458@naver.com"
            this.createdAt = "2022-06-20 17:47:00"
        }

        val json = jacksonObjectMapper().writeValueAsString(userRequest)

        mockMvc.perform(
            post("/api/post-mapping/object")
                .content(json)
                .contentType("application/json")
                .accept("application/json")
        ).andExpect(
            status().isOk
        ).andExpect(
            jsonPath("\$.name").value("giri")
        ).andExpect(
            jsonPath("\$.age").value("10")
        ).andExpect(
            jsonPath("\$.phoneNumber").value("010-1111-2222")
        )
    }

    @Test
    fun postFailTest(){
        val userRequest = UserRequest().apply {
            this.name = "giri"
            this.age = -1
            this.phoneNumber = "010-1111-2222"
            this.address = "서울시 관악구"
            this.email = "qws458@naver.com"
            this.createdAt = "2022-06-20 17:47:00"
        }

        val json = jacksonObjectMapper().writeValueAsString(userRequest)

        mockMvc.perform(
            post("/api/post-mapping/object")
                .content(json)
                .contentType("application/json")
                .accept("application/json")
        ).andExpect(
            status().isBadRequest
        ).andDo(print())
    }
}