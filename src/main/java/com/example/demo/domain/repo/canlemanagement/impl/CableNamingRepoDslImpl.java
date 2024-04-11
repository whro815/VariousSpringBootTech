package com.example.demo.domain.repo.canlemanagement.impl;


import com.example.demo.domain.repo.BaseRepo;
import com.example.demo.domain.repo.canlemanagement.CableNamingRepoDsl;
import com.example.demo.dto.cablemanagement.CableNamingDto;
import com.querydsl.core.types.ConstantImpl;

import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.example.demo.utils.CableConstructorSettings;

import java.util.List;

import static com.example.demo.domain.entity.QCableNamingEntity.cableNamingEntity;

public class CableNamingRepoDslImpl extends BaseRepo implements CableNamingRepoDsl {

     public CableNamingRepoDslImpl(JPAQueryFactory jpaQueryFactory) {
        super(jpaQueryFactory);
        //TODO Auto-generated constructor stub
    }


//   0


    @Override
    public List<CableNamingDto> findCableNamingList(String pid) {

         return jpaQueryFactory.select(
                                        Projections.constructor(

                                                CableNamingDto.class,
                                                cableNamingEntity.cnid,
                                                cableNamingEntity.pid,
                                                cableNamingEntity.uid,
                                                cableNamingEntity.type,
                                                cableNamingEntity.ctype,
                                                cableNamingEntity.name,
                                                cableNamingEntity.orderno,
                                                cableNamingEntity.seq_num,
                                                cableNamingEntity.roles,
                                                Expressions.as (
                                                    Expressions.stringTemplate (
                                                            "DATE_FORMAT(FROM_UNIXTIME({0}), {1})"
                                                            , cableNamingEntity.reg_dt
                                                            , ConstantImpl.create("%Y%m%d")
                                                    )
                                                    ,"reg_date"
                                                )

                                        )
                                    )
                                .from(cableNamingEntity)
                                .where(cableNamingEntity.pid.eq(pid))
                                .orderBy(cableNamingEntity.type.asc(),cableNamingEntity.orderno.asc())
                                .fetch();

    }

//    @Override
//    public CableNamingDto findCableDataInfo(Long cnid) {
//       return jpaQueryFactory.select(CableDataContructor)
//                            .from(cableNamingEntity)
//                            .where(cableNamingEntity.cnid.eq(cnid).and(cableNamingEntity.del_yn.eq("N")))
//                            .fetchOne();
//    }
}
