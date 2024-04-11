package com.example.demo.domain.repo;


import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class BaseRepo {

    protected final JPAQueryFactory jpaQueryFactory;
}
