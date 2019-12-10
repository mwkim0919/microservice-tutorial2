package com.minwoo.microservices.netflixzuulapigatewayserver

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class ZuulLoggingFilter: ZuulFilter() {
  private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

  override fun run(): Any {
    val request = RequestContext.getCurrentContext().request
    logger.info("request -> {} request uri -> {}", request, request.requestURI)
    return ""
  }

  override fun shouldFilter(): Boolean {
    return true
  }

  override fun filterType(): String {
    return "pre"
  }

  override fun filterOrder(): Int {
    return 0
  }
}