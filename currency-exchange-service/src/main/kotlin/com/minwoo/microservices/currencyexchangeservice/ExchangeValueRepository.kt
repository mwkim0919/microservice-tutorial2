package com.minwoo.microservices.currencyexchangeservice

import org.springframework.data.jpa.repository.JpaRepository

interface ExchangeValueRepository : JpaRepository<ExchangeValue, Long> {
  fun findByFromAndTo(from: String, to: String): ExchangeValue
}