package com.resource.horizon.repository

import com.resource.horizon.model.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<User, Int> {
    fun existsByUserId(userId: String): Boolean
    fun existsByEmail(userEmail: String): Boolean
    fun findByEmail(userEmail: String): User
    fun findByUserId(userId: String): User
    fun deleteByUserId(userId: String): String
}