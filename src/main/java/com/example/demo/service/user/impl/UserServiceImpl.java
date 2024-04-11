package com.example.demo.service.user.impl;


import com.example.demo.domain.repo.user.UserRepo;
import com.example.demo.domain.repo.user.UserRepoDsl;
import com.example.demo.dto.cablemanagement.CableNamingDto;
import com.example.demo.dto.user.UserDto;
import com.example.demo.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.bcel.ExceptionRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Transactional(readOnly = true)
    @Override
    public List<UserDto> selectUserInfo(String uid) {
        List<UserDto> userDtos = userRepo.selectUserInfoList(uid);
        return userDtos;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean insertUserInfo(UserDto userDto) {
        try {
            userRepo.save(userDto.toEntity());
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
