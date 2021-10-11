package com.resource.horizon.controller


import com.resource.horizon.model.User
import com.resource.horizon.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = ["*"], maxAge = 3600)
class UserController(
    val userService: UserService
) {
    @GetMapping("/users")
    fun getAllUsers(): List<User> {
        return userService.getAllUsers()
    }

    @GetMapping("/users/{userId}")
    fun findUsersById(@PathVariable userId: String): User {
        return userService.findUsersById(userId)
    }

    @PutMapping("/users")
    fun updateUser(@RequestBody user: User): User {
        return userService.updateUser(user)
    }

    @DeleteMapping("/users/{userId}")
    fun deleteUser(@PathVariable userId: String): String {
        return userService.deleteUserById(userId)
    }

}