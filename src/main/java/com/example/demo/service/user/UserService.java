package com.example.demo.service.user;

import com.example.demo.dto.cablemanagement.CableNamingDto;
import com.example.demo.dto.user.UserDto;

import java.util.List;

public interface UserService {

    UserDto selectUserInfo(String uid);
    boolean insertUserInfo(UserDto userDto);

    boolean updateUserInfo(UserDto userDto);

}
