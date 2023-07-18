package com.lcwd.electronic.store.controllers;

import com.lcwd.electronic.store.dtos.UserDto;

import com.lcwd.electronic.store.payload.AppConstants;
import com.lcwd.electronic.store.services.UserServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

//import javax.Validated.Valid;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserServiceI userServiceI;


    /**
     * @param userDto
     * @return User
     * @author Lalit Mokasare
     * @apiNote Create User
     */


    //create
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        log.info("Starting request to create User");
        UserDto user = userServiceI.createUser(userDto);
        log.info("Completed request of create User");
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }


    /**
     * @param userDto
     * @return User
     * @author Lalit Mokasare
     * @apiNote Update User
     */


    //update
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(
            @PathVariable("userId") String userId, @Valid @RequestBody UserDto userDto) {
        log.info("Initiating request to update User:{}", userId);
        UserDto updatedUserDto = userServiceI.updateUser(userDto, userId);
        log.info("Completed request of update User:{}", userId);

        return new ResponseEntity<>(updatedUserDto, HttpStatus.OK);
    }


    /**
     * @param userId
     * @author Lalit Mokasare
     * @apiNote Delete User
     */


    //delete
    @DeleteMapping("/{userId}")
    public ResponseEntity deleteUser(@PathVariable String userId) {
        log.info("Initiating request to delete User");
        userServiceI.deleteuser(userId);
        log.info("Completed request delete User");

        return new ResponseEntity<>(AppConstants.DELETE_USER, HttpStatus.OK);
        //  return new ResponseEntity<>("Delete user successfully", HttpStatus.OK);

    }

    /**
     * @return All User
     * @author Lalit Mokasare
     * @apiNote Get All User
     */


    //get all
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    ) {

        log.info("Initiating request to get all User");
        List<UserDto> allUsers = userServiceI.getAllUser(pageNumber, pageSize);
        log.info("Completed request of get all User");

        return new ResponseEntity<List<UserDto>>(allUsers, HttpStatus.OK);
    }

    /**
     * @param userId
     * @return User
     * @author Lalit Mokasare
     * @apiNote Get User By Id
     */


    //get single user by id
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable String userId) {
        log.info("Initiating request to get User by Id");
        UserDto SingleUserById = userServiceI.getUserById(userId);
        log.info("Completed request of get User by Id");

        return new ResponseEntity<UserDto>(SingleUserById, HttpStatus.OK);
    }

    /**
     * @param email
     * @return User
     * @author Lalit Mokasare
     * @apiNote Get User By email
     */


    //get email by user
    @GetMapping("/email/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email) {
        log.info("Initiating request to get User by email");
        UserDto userByEmail = userServiceI.getUserByEmail(email);
        log.info("Completed request of get User by email");

        return new ResponseEntity<>(userByEmail, HttpStatus.OK);
    }

    /**
     * @param keywords
     * @return User
     * @author Lalit Mokasare
     * @apiNote Get User By Keyword
     */


    //search user
    @GetMapping("/search/{keywords}")
    public ResponseEntity<List<UserDto>> getUserByKeyword(@PathVariable String keywords) {
        log.info("Initiating request to search by keyword");
        List<UserDto> userDtoByKeyword = userServiceI.searchUser(keywords);
        log.info("Completed request of search by keyword");

        return new ResponseEntity<>(userDtoByKeyword, HttpStatus.OK);
    }

}
