package com.example.demo.domain.repo.user.impl;

import com.example.demo.domain.entity.user.UserEntity;
import com.example.demo.domain.repo.BaseRepo;
import com.example.demo.domain.repo.user.UserRepoDsl;
import com.example.demo.dto.user.UserDto;
import com.querydsl.core.types.ConstantImpl;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.List;

import static com.example.demo.domain.entity.QCableNamingEntity.cableNamingEntity;
import static com.example.demo.domain.entity.user.QUserEntity.userEntity;

public class UserRepoDslImpl extends BaseRepo implements UserRepoDsl {

     public UserRepoDslImpl(JPAQueryFactory jpaQueryFactory) {
        super(jpaQueryFactory);
        //TODO Auto-generated constructor stub
    }

    @Override
    public UserDto selectUserInfo(String uid) {
        return jpaQueryFactory.select(
                        Projections.constructor(
                            UserDto.class,
                            userEntity.uid,
                            userEntity.email,
                            userEntity.name,
                            userEntity.role,
                            Expressions.as (
                                Expressions.stringTemplate (
                                        "DATE_FORMAT(FROM_UNIXTIME({0}), {1})"
                                        ,userEntity.reg_dt
                                        ,ConstantImpl.create("%Y%m%d")
                                )
                                ,"reg_date"
                              )
                        )
                )
                .from(userEntity)
                .where(userEntity.del_yn.eq("N").and(userEntity.uid.eq(uid)))
                .fetchFirst();
    }
}
