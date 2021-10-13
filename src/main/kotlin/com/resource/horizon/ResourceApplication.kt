package com.resource.horizon

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
@OpenAPIDefinition(
    info = Info(
        title = "Horizon Resource API",
        version = "1.1.6",
        description = "Information regarding Horizon Resource APIs"
    )
)
class ResourceApplication
var log: Logger = LoggerFactory.getLogger(ResourceApplication::class.java)

fun main(args: Array<String>) {
    runApplication<ResourceApplication>(*args)
    log.info("Resource Application Started")
}