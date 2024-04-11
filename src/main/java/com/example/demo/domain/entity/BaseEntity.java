package com.example.demo.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

@Slf4j
@Data
@MappedSuperclass
public class BaseEntity {
    
    @Column(name = "reg_dt",insertable = true,updatable = false)
    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    protected Integer reg_dt;

    @Column(name = "del_yn",insertable = true,updatable = true)
    @ColumnDefault("'N'") //이부분 에러 추후 확인 필요...
    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    protected String del_yn;
    
    @PrePersist
    protected void onCreate() {
        Date date = new Date();
        long unixTime = (long)date.getTime()/1000;
        reg_dt = (int) unixTime;
        if(!org.springframework.util.StringUtils.hasText(del_yn)){
            del_yn = "N";
        }
    }

    @PreUpdate
    protected void onUpdate() {        
        if(!org.springframework.util.StringUtils.hasText(del_yn)){
            del_yn="N";            
        }
    }
}
