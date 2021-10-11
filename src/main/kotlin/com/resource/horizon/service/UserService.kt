package com.resource.horizon.service

import com.resource.horizon.model.User
import com.resource.horizon.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable

@Service
class UserService(val userRepository: UserRepository) {

    fun updateUser(user: User): User {
        val doesExistByEmail = userRepository.existsByEmail(user.email)
        if (doesExistByEmail) {
            val fetchedUser: User = userRepository.findByEmail(user.email)
            fetchedUser.name = user.name
            fetchedUser.insuranceType = user.insuranceType
            fetchedUser.phone = user.phone
            fetchedUser.address = user.address
            return userRepository.save(fetchedUser)
        } else {
            user.userId = "NULL"
            user.name = "NULL"
            user.address = "NULL"
            user.insuranceType = "NULL"
            user.email = "NULL"
            user.phone = "NULL"
            return user
        }
    }

    fun deleteUser(@PathVariable userId: String): String {
        val doesExistByUserId = userRepository.existsByUserId(userId)
        println(doesExistByUserId)
        println(userId)
        return if (doesExistByUserId) {
            userRepository.deleteByUserId(userId)
            "Deleted"
        } else
            "Does not exist"
    }

    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    fun findUsersById(userId: String): User {
        return userRepository.findByUserId(userId)
    }
}