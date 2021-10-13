package com.resource.horizon

import com.resource.horizon.model.Motor
import com.resource.horizon.repository.MotorRepository
import com.resource.horizon.service.MotorService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean

@SpringBootTest
class ResourceApplicationTests {

    @MockBean
    val motorRepository: MotorRepository? = null

    @Autowired
    var motorService: MotorService? = null

    @Test
    fun getAllMotorsTest() {
        val motor = Motor("MOTR0001", "Audi", "A4")
        Mockito.`when`(motorRepository!!.findAll()).thenReturn(listOf(motor))
        Assertions.assertEquals(1, motorService!!.getAllMotors().size)
    }

    @Test
    fun getMotorByIdTest() {
        val motorId = "MOTR0001"
        val motor = Motor("MOTR0001", "Audi", "A4")
        Mockito.`when`(motorRepository!!.findByMotorId(motorId)).thenReturn(motor)
        Assertions.assertEquals(motor, motorService!!.findMotorDetailsById(motorId))
    }

    @Test
    fun updateMotorDetailsTest() {
        val motor = Motor("MOTR0001", "Audi", "A4")
        motor.motorId = "MOTR0001"
        motor.motorMake = "Audi"
        motor.motorModel = "A4"
        Mockito.`when`(motorRepository!!.save(motor)).thenReturn(motor)
        Assertions.assertEquals(motor, motorService!!.updateMotor(motor))
    }

    @Test
    fun addNewMotorTest() {
        val motor = Motor("MOTR0001", "Audi", "A4")
        Mockito.`when`(motorRepository!!.save(motor)).thenReturn(motor)
        Assertions.assertEquals(motor, motorService!!.addNewMotor(motor))
    }

    @Test
    fun deleteMotorByIdTest() {
        val motorId = "MOTR0001"
        val response = "Deleted"
        Mockito.`when`(motorRepository!!.deleteByMotorId(motorId)).thenReturn(response)
        Assertions.assertEquals(response, motorService!!.deleteMotorByMotorId(motorId))
    }


}
