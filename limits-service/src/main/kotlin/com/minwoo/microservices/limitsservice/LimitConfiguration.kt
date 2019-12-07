package com.minwoo.microservices.limitsservice

data class LimitConfiguration(
  val maximum: Int,
  val minimum: Int)