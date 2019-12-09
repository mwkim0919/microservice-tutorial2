package com.minwoo.microservices.currencyconversionservice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
class CurrencyConversionController {

  @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
  fun convertCurrency(
    @PathVariable from: String,
    @PathVariable to: String,
    @PathVariable quantity: BigDecimal): CurrencyConversionBean {
    val currencyConversionBean = CurrencyConversionBean(1L, from, to, BigDecimal.ONE, quantity, BigDecimal.ONE, 0)
    return currencyConversionBean
  }
}