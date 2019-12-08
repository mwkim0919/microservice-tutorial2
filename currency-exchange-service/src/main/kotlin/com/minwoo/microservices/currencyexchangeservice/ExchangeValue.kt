package com.minwoo.microservices.currencyexchangeservice

import java.math.BigDecimal

data class ExchangeValue(
  val id: Long,
  val from: String,
  val to: String,
  val conversionMultiple: BigDecimal,
  val port: Int
)