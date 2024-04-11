package com.example.demo.domain.repo.user;

import com.example.demo.domain.entity.user.UserEntity;
import com.example.demo.dto.user.UserDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepoDsl {
    @Transactional(readOnly = true)
    List<UserDto> selectUserInfoList(String uid);

}
