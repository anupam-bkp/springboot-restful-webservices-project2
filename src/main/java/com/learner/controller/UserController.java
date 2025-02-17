package com.learner.controller;

import com.learner.dto.UserDto;
import com.learner.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Create a new user
    //http://localhost:8080/api/users (Pass Json RequestBody)
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
        final UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    //Get user by id REST Api
    // http://localhost:8080/api/users/id
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") long userId){
        UserDto userById = userService.getUserById(userId);
        return new ResponseEntity<>(userById, HttpStatus.OK);
    }

    //Get All users REST Api
    //http://localhost:8080/api/users
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    //Update User REst Api
    //http://localhost:8080/api/users/id
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") long id, @RequestBody UserDto user){
        user.setId(id);
        UserDto userDto = userService.updateUser(user);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    //Delete user api
    //http://localhost:8080/api/users/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id){
        userService.deleteUser(id);
        return new ResponseEntity<>("User Deleted Successfully", HttpStatus.OK);
    }
}
