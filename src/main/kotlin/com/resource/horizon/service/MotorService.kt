package com.resource.horizon.service

import com.resource.horizon.model.Motor
import com.resource.horizon.repository.MotorRepository
import org.springframework.stereotype.Service

@Service
class MotorService (val motorRepository: MotorRepository) {
    fun getAllMotors(): List<Motor> {
        return motorRepository.findAll()
    }

    fun addNewMotor(motor: Motor): Motor {
        return motorRepository.save(motor)
    }

    fun findMotorDetailsById(motorId: String): Motor {
        return motorRepository.findByMotorId(motorId)
    }

    fun updateMotor(motor: Motor): Motor {
        return motorRepository.save(motor)
    }

    fun deleteMotorByMotorId(motorId: String): String {
        motorRepository.deleteByMotorId(motorId)
        return "Deleted"
    }


}