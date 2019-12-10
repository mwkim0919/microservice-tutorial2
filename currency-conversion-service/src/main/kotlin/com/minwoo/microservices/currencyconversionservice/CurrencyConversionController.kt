package com.minwoo.microservices.currencyconversionservice

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import java.math.BigDecimal

@RestController
class CurrencyConversionController
@Autowired constructor(
  private val currencyExchangeServiceProxy: CurrencyExchangeServiceProxy
) {

  private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

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

    return response?.id?.let {
      CurrencyConversionBean(
        it,
        from,
        to,
        response.conversionMultiple,
        quantity,
        quantity.multiply(response.conversionMultiple),
        response.port
      )
    }
  }

  @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
  fun convertCurrencyFeign(
    @PathVariable from: String,
    @PathVariable to: String,
    @PathVariable quantity: BigDecimal): CurrencyConversionBean? {

    val response = currencyExchangeServiceProxy.retrieveExchangeValue(from, to)

    logger.info("response -> {}", response)

    return response.id?.let {
      CurrencyConversionBean(
        it,
        from,
        to,
        response.conversionMultiple,
        quantity,
        quantity.multiply(response.conversionMultiple),
        response.port
      )
    }
  }
}