package com.lcwd.electronic.store.services;

import com.lcwd.electronic.store.dtos.UserDto;

import java.util.List;

public interface UserServiceI {

     // create

    UserDto createUser(UserDto userDto);


    // update

      UserDto  updateUser(UserDto userDto,String userId);


    // delete
      void deleteuser(String userId);


    // get all userse
       List<UserDto> getAllUser();


    // get single users by id

    UserDto getUserById(String userId);

    // get single users by email
     UserDto getUserByEmail(String email);

    // search user

     List<UserDto>searchUser(String keyword);

    void deleteUser(String userId);

    List<UserDto> getAllUser(int pageNumber, int pageSize);


    // either user specific features



















}
