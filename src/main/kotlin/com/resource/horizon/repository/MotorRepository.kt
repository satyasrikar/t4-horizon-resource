package com.resource.horizon.repository

import com.resource.horizon.model.Motor
import org.springframework.data.mongodb.repository.MongoRepository

interface MotorRepository : MongoRepository<Motor, String> {

    fun findByMotorId(motorId: String) : Motor
    fun deleteByMotorId(motorId: String):String
}