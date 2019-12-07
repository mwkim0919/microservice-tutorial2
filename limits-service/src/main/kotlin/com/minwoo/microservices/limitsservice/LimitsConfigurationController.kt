package com.minwoo.microservices.limitsservice

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LimitsConfigurationController

@Autowired constructor(
  private val configuration: Configuration) {

  @GetMapping("/limits")
  fun retrieveLimitsFromConfigurations(): LimitConfiguration {
    return LimitConfiguration(configuration.maximum, configuration.minimum)
  }

}
