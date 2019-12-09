package com.minwoo.microservices.currencyexchangeservice

import java.math.BigDecimal
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class ExchangeValue(
  @Id val id: Long,
  @Column(name="currency_from") val from: String,
  @Column(name="currency_to") val to: String,
  val conversionMultiple: BigDecimal,
  var port: Int?
) {
  // Why JPA! Why do you make me do this!?
  private constructor(): this(0, "", "", BigDecimal.ZERO, 0)
}