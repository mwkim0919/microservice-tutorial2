package com.minwoo.microservices.limitsservice

import brave.sampler.Sampler
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.context.annotation.Bean

@SpringBootApplication
@EnableDiscoveryClient
class LimitsServiceApplication

fun main(args: Array<String>) {
  runApplication<LimitsServiceApplication>(*args)
}

@Bean
fun defaultSampler(): Sampler {
  return Sampler.ALWAYS_SAMPLE
}
