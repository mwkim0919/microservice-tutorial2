package com.minwoo.microservices.currencyconversionservice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import java.math.BigDecimal

@RestController
class CurrencyConversionController {

  @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
  fun convertCurrency(
    @PathVariable from: String,
    @PathVariable to: String,
    @PathVariable quantity: BigDecimal): CurrencyConversionBean? {

    val uriVariables = HashMap<String, String>()
    uriVariables["from"] = from
    uriVariables["to"] = to

    val responseEntity = RestTemplate().getForEntity(
      "http://localhost:8000/currency-exchange/from/${from}/to/${to}",
      CurrencyConversionBean::class.java,
      uriVariables)

    val response = responseEntity.body

    val currencyConversionBean = response?.id?.let {
      CurrencyConversionBean(
        it,
        from,
        to,
        response.conversionMultiple,
        quantity,
        quantity.multiply(response.conversionMultiple),
        0
      )
    }
    return currencyConversionBean
  }
}