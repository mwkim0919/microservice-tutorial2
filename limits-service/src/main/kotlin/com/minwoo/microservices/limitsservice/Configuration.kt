package com.minwoo.microservices.limitsservice

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("limits-service")
class Configuration {
  var maximum: Int = 0
  var minimum: Int = 0
}