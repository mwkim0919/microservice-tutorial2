package com.minwoo.microservices.currencyexchangeservice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
class CurrencyExchangeController {

  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  fun retrieveExchangeValue(@PathVariable from: String, @PathVariable to: String): ExchangeValue {
    return ExchangeValue(1000L, from, to, BigDecimal.ONE)
  }
}