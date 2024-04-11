package com.example.demo.domain.repo.user;

import com.example.demo.domain.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, Long>, UserRepoDsl {

}
