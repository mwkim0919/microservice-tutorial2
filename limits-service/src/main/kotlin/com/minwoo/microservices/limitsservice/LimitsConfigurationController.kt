package com.minwoo.microservices.limitsservice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LimitsConfigurationController {

  @GetMapping("/limits")
  fun retrieveLimitsFromConfigurations(): LimitConfiguration {
    return LimitConfiguration(1000, 1)
  }

}
