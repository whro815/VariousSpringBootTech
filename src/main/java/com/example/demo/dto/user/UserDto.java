package com.example.demo.dto.user;

import com.example.demo.domain.entity.user.UserEntity;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class UserDto {
    @JsonAlias("uid")
    private String uid;
    @JsonAlias("email")
    protected String email;
    @JsonAlias("name")
    private String name;
    @JsonAlias("pwd")
    private String pwd;
    @JsonAlias("role")
    private String role;
//    @JsonAlias("settings")
//    private List<UserSettingsDto> settings;

    public UserEntity toEntity(){
        return UserEntity.builder()
                .uid(uid)
                .email(email)
                .pwd(pwd)
                .name(name)
                .role(role)
                .build();
    }

    @Builder
    public UserDto(String uid, String email,String name,String pwd,String role) {
        this.uid = uid;
        this.email = email;
        this.name = name;
        this.pwd = pwd;
        this.role = role;
    }

//    public void setSettings(List<UserSettingsDto> settings){
//        this.settings=settings;
//    }

    public void setPwd(String pwd){
        this.pwd = pwd;
    }
}
