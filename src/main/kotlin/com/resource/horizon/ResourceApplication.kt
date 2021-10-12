package com.resource.horizon

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ResourceApplication

var log: Logger = LoggerFactory.getLogger(ResourceApplication::class.java)


fun main(args: Array<String>) {
	runApplication<ResourceApplication>(*args)
	log.info("Resource Application Started")
}
