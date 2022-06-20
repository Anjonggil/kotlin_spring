package com.example.mvc.domain

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

data class UserResponse(
  var  result:com.example.mvc.domain.Result?=null,
  var description:String?=null,

  @JsonProperty("user")
  var userRequest: List<UserRequest>?=null
)

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class Result(
  var resultCode:String?=null,
  var resultMessage:String?=null
)