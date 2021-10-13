package com.resource.horizon.controller

import com.resource.horizon.model.Motor
import com.resource.horizon.model.Partner
import com.resource.horizon.service.MotorService
import com.resource.horizon.service.PartnerService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/v1/store")
@CrossOrigin(origins = ["*"], maxAge = 3600)
class StoreController(
    val motorService: MotorService,
    val partnerService: PartnerService
) {

    //MOTOR CONTROLLER METHODS
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

    //PARTNER CONTROLLER METHODS

    @GetMapping("/partners")
    fun viewAllPartners(): List<Partner> {
        return partnerService.viewAllPartners()
    }

    @PostMapping("/partners")
    fun addNewPartner(@RequestBody partner: Partner) : Partner {
        return partnerService.addNewPartner(partner)
    }

    @GetMapping("/partners/{partnerId}")
    fun findPartnerById(@PathVariable partnerId: String): Partner {
        return partnerService.viewPartnerById(partnerId)
    }

    @PutMapping("/partners")
    fun updatePartner(@RequestBody partner: Partner): Partner {
        return partnerService.updatePartner(partner)
    }

    @DeleteMapping("/partners/{partnerId}")
    fun deletePartner(@PathVariable partnerId: String): String {
        return partnerService.deletePartnerByPartnerId(partnerId)
    }




}
