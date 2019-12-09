package com.minwoo.microservices.currencyconversionservice

import java.math.BigDecimal

data class CurrencyConversionBean (
  val id: Long,
  val from: String,
  val to: String,
  val conversionMultiple: BigDecimal,
  val quantity: BigDecimal,
  val totalCalculatedAmount: BigDecimal,
  val port: Int?
) {
  private constructor(): this(
    0,
    "",
    "",
    BigDecimal.ZERO,
    BigDecimal.ZERO,
    BigDecimal.ZERO,
    0)
}
