package com.example.demo.domain.entity.user;


import com.example.demo.domain.entity.BaseEntity;
import com.example.demo.dto.user.UserDto;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "TB_USER_INFO")
@Entity
@Getter
@Setter
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
public class UserEntity extends BaseEntity {
    @Id
    @Column(name = "uid")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Schema(example = "사용자아이디")
    private String uid;
    @Column(name = "email")
    //@Schema(example = "이메일")
    @JsonAlias("email")
	private String email;
    @Column(name = "pwd")
    @JsonAlias("pwd")
    //@Schema(example = "비밀번호")
	private String pwd;
    @Column(name = "name")
    //@Schema(example = "사용자명")
	private String name;
    @Column(name = "role")
    //@Schema(example = "사용자유형", allowableValues = {"ADMIN","USER"})
	private String role;

    public UserDto toDto(){
        return UserDto.builder().uid(uid).pwd(pwd).email(email).name(name).role(role).build();
    }

    @Builder
    public UserEntity(String uid, String email, String pwd, String name,String role) {
        this.uid = uid;
        this.email = email;
        this.pwd = pwd;
        this.name = name;
        this.role = role;
    }
}
