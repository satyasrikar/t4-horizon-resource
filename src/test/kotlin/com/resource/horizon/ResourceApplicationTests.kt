package com.resource.horizon

import com.resource.horizon.model.Motor
import com.resource.horizon.model.User
import com.resource.horizon.repository.MotorRepository
import com.resource.horizon.repository.UserRepository
import com.resource.horizon.service.MotorService
import com.resource.horizon.service.UserService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean

@SpringBootTest
class ResourceApplicationTests {

    @MockBean
    val userRepository: UserRepository? = null

    @Autowired
    var userService: UserService? = null

    @MockBean
    val motorRepository: MotorRepository? = null

    @Autowired
    var motorService: MotorService? = null

    @Test
    fun getAllUsersTest() {
        val user = User()
        user.userId = "USR0001"
        user.address = "GroveStreet"
        user.email = "user@horizon.com"
        user.name = "User"
        user.phone = "911"
        user.insuranceType = "motor"

        Mockito.`when`(userRepository!!.findAll())
            .thenReturn(listOf(user))
        Assertions.assertEquals(1, userService!!.getAllUsers().size)
    }


    @Test
    fun getUserByIdTest() {
        val userId = "USR0001"
        val user = User()
        user.userId = "USR0001"
        user.address = "GroveStreet"
        user.email = "user@horizon.com"
        user.name = "User"
        user.phone = "911"
        user.insuranceType = "motor"
        Mockito.`when`(userRepository!!.findByUserId(userId))
            .thenReturn(user)
        Assertions.assertEquals(user, userService!!.findUsersById(userId))
    }

    @Test
    fun updateUserTest() {
        val user = User()
        user.userId = "USR0001"
        user.address = "GroveStreet"
        user.email = "user@horizon.com"
        user.name = "User"
        user.phone = "911"
        user.insuranceType = "motor"
        Mockito.`when`(userRepository!!.save(user))
            .thenReturn(user)
        Assertions.assertEquals(user, userService!!.updateUser(user))
    }

	@Test
	fun deleteUserTest(){
		val userId = "USR0001"
		val response = "Deleted"
        Mockito.`when`(userRepository!!.existsByUserId(userId))
            .thenReturn(true)
		Mockito.`when`(userRepository!!.deleteByUserId(userId))
			.thenReturn(response)
		Assertions.assertEquals(response, userService!!.deleteUserById(userId))
	}

	@Test
    fun existsByUserIdPassTest() {
        val userId = "USR0001"
        Mockito.`when`(userRepository!!.existsByUserId(userId))
            .thenReturn(true)
        Assertions.assertTrue(userRepository!!.existsByUserId(userId))
    }

    @Test
    fun existsByUserIdFailTest() {
        val userId = "USR0001"
        Mockito.`when`(userRepository!!.existsByUserId(userId))
            .thenReturn(false)
        Assertions.assertFalse(userRepository!!.existsByUserId(userId))
    }



    @Test
    fun existsByUserEmailFailTest() {
        val userEmail = "user@horizon.com"
        Mockito.`when`(userRepository!!.existsByUserId(userEmail))
            .thenReturn(false)
        Assertions.assertFalse(userRepository!!.existsByUserId(userEmail))
    }

    @Test
    fun existsByUserEmailPassTest() {
        val userEmail = "user@horizon.com"
        Mockito.`when`(userRepository!!.existsByUserId(userEmail))
            .thenReturn(true)
        Assertions.assertTrue(userRepository!!.existsByUserId(userEmail))
    }








}
