package com.example.mvc.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.util.LinkedMultiValueMap

@WebMvcTest
@AutoConfigureMockMvc
internal class GetApiControllerTest{

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun getMappingTest(){
        mockMvc.perform(
            get("/api/hello")
        ).andExpect(status().isOk
        ).andExpect (
            content().string("hello kotlin")
        ).andDo(print())
    }

    @Test
    fun getTest(){
        val queryParam = LinkedMultiValueMap<String,String>()
        queryParam.add("name","giri")
        queryParam.add("age","20")

        mockMvc.perform(
            get("/api/hello").queryParams(queryParam)
        ).andExpect(status().isOk
        ).andExpect (
            content().string("hello kotlin")
        ).andDo(print())
    }

}