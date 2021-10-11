package com.resource.horizon.controller

import com.resource.horizon.model.Motor
import com.resource.horizon.service.MotorService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/v1/store")
@CrossOrigin(origins = ["*"], maxAge = 3600)
class StoreController(
    val motorService: MotorService
) {
    @GetMapping("/motors")
    fun getAllMotors(): List<Motor> {
        return motorService.getAllMotors()
    }

    @PostMapping("/motors")
    fun addNewMotor(@RequestBody motor: Motor) : Motor {
        return motorService.addNewMotor(motor)
    }

    @GetMapping("/motors/{motorId}")
    fun findMotorById(@PathVariable motorId: String): Motor {
        return motorService.findMotorDetailsById(motorId)
    }

    @PutMapping("/motors")
    fun updateMotorDetails(@RequestBody motor: Motor): Motor {
        return motorService.updateMotor(motor)
    }

    @DeleteMapping("/motors/{motorId}")
    fun deleteMotor(@PathVariable motorId: String): String {
        return motorService.deleteMotorByMotorId(motorId)
    }

}
