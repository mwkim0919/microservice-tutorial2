package com.minwoo.microservices.currencyconversionservice

import org.springframework.cloud.netflix.ribbon.RibbonClient
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "currency-exchange-service")
@RibbonClient(name = "currency-exchange-service")
interface CurrencyExchangeServiceProxy {
  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  fun retrieveExchangeValue(@PathVariable("from") from: String, @PathVariable("to") to: String): CurrencyConversionBean
}