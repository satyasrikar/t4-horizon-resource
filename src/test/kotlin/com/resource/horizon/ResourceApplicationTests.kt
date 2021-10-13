package com.resource.horizon

import com.resource.horizon.model.Motor
import com.resource.horizon.model.Partner
import com.resource.horizon.repository.MotorRepository
import com.resource.horizon.repository.PartnerRepository
import com.resource.horizon.service.MotorService
import com.resource.horizon.service.PartnerService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean

@SpringBootTest
class ResourceApplicationTests {

    @MockBean
    lateinit var motorRepository: MotorRepository

    @Autowired
    lateinit var motorService: MotorService

    @MockBean
    lateinit var partnerRepository: PartnerRepository

    @Autowired
    lateinit var partnerService: PartnerService

    @Test
    fun getAllMotorsTest() {
        val motor = Motor("MOTR0001", "Audi", "A4")
        Mockito.`when`(motorRepository.findAll()).thenReturn(listOf(motor))
        Assertions.assertEquals(1, motorService.getAllMotors().size)
    }

    @Test
    fun getMotorByIdTest() {
        val motorId = "MOTR0001"
        val motor = Motor("MOTR0001", "Audi", "A4")
        Mockito.`when`(motorRepository.findByMotorId(motorId)).thenReturn(motor)
        Assertions.assertEquals(motor, motorService.findMotorDetailsById(motorId))
    }

    @Test
    fun updateMotorDetailsTest() {
        val motor = Motor("MOTR0001", "Audi", "A4")
        motor.motorId = "MOTR0001"
        motor.motorMake = "Audi"
        motor.motorModel = "A4"
        Mockito.`when`(motorRepository.save(motor)).thenReturn(motor)
        Assertions.assertEquals(motor, motorService.updateMotor(motor))
    }

    @Test
    fun addNewMotorTest() {
        val motor = Motor("MOTR0001", "Audi", "A4")
        Mockito.`when`(motorRepository.save(motor)).thenReturn(motor)
        Assertions.assertEquals(motor, motorService.addNewMotor(motor))
    }

    @Test
    fun deleteMotorByIdTest() {
        val motorId = "MOTR0001"
        val response = "Deleted"
        Mockito.`when`(motorRepository.deleteByMotorId(motorId)).thenReturn(response)
        Assertions.assertEquals(response, motorService.deleteMotorByMotorId(motorId))
    }


    @Test
    fun viewAllPartnersTest(){
        val partner = Partner()
        partner.partnerId = "HORZ0001"
        partner.IRDA = "IRDA/HZ/0001"
        partner.insuranceOffered = "health"
        partner.name = "HorizonPartner"
        Mockito.`when`(partnerRepository.findAll()).thenReturn(listOf(partner))
        Assertions.assertEquals(1, partnerService.viewAllPartners().size)
    }


    @Test
    fun viewPartnerByIdTest(){
        val partnerId = "HORZ0001"
        val partner = Partner()
        partner.partnerId = "HORZ0001"
        partner.IRDA = "IRDA/HZ/0001"
        partner.insuranceOffered = "health"
        partner.name = "HorizonPartner"
        Mockito.`when`(partnerRepository.findPartnerByPartnerId(partnerId)).thenReturn(partner)
        Assertions.assertEquals(partner, partnerService.viewPartnerById(partnerId))
    }

    @Test
    fun addNewPartnerTest() {
        val partner = Partner()
        partner.partnerId = "HORZ0001"
        partner.IRDA = "IRDA/HZ/0001"
        partner.insuranceOffered = "health"
        partner.name = "HorizonPartner"
        Mockito.`when`(partnerRepository.save(partner)).thenReturn(partner)
        Assertions.assertEquals(partner, partnerService.addNewPartner(partner))
    }

    @Test
    fun updatePartnerTest() {
        val partner = Partner()
        partner.partnerId = "HORZ0001"
        partner.IRDA = "IRDA/HZ/0001"
        partner.insuranceOffered = "health"
        partner.name = "HorizonPartner"
        Mockito.`when`(partnerRepository.save(partner)).thenReturn(partner)
        Assertions.assertEquals(partner, partnerService.updatePartner(partner))
    }

    @Test
    fun deletePartnerByIdTest(){
        val partnerId = "HORZ0001"
        val response = "Deleted"
        Mockito.`when`(partnerRepository.deletePartnerByPartnerId(partnerId)).thenReturn(response)
        Assertions.assertEquals(response, partnerRepository.deletePartnerByPartnerId(partnerId))
    }


}
