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
    //@Schema(description ="사용자아이디", example = "7780EB5F")
    @JsonAlias("uid")
    private String uid;

    //@Schema(description ="아이디" , example = "test001")
    //@Email(message = "ID is invalid.")
    //@NotBlank(message="ID is mandatory.")
    @JsonAlias("email")
    protected String email;

    //@Schema(description ="이름" , example = "홍길동")
    @JsonAlias("name")
    private String name;

    //@Schema(description ="비밀번호(영문+숫자 6~12자리 이내로 입력)" , example = "eap1234")
    //@Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=\\S+$).{6,12}", message = "Please enter your password within 6 to 12 digits including English + numbers.")
    //@Size(min = 6, max=12, message = "The password length is incorrect.")
    @JsonAlias("pwd")
    private String pwd;

    //@Schema(description ="역할" , allowableValues = {"ADMIN","USER"})
    //@Pattern(regexp = "ADMIN|USER", message = "role : No value found.")
    @JsonAlias("role")
    private String role;

    //@Schema(description ="사용자설정")
    @JsonAlias("settings")
    private List<UserSettingsDto> settings;

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

    public void setSettings(List<UserSettingsDto> settings){
        this.settings=settings;
    }

    public void setPwd(String pwd){
        this.pwd = pwd;
    }
}
