package com.minwoo.microservices.currencyexchangeservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class CurrencyExchangeServiceApplication

fun main(args: Array<String>) {
	runApplication<CurrencyExchangeServiceApplication>(*args)
}
