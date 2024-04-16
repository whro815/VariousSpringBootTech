package com.example.demo.controller.user;

import com.example.demo.dto.user.UserDto;
import com.example.demo.service.user.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.source.tree.AssertTree;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;


import static com.example.demo.utils.CableNamingAttributeConverter.objectMapper;
import static org.mockito.ArgumentMatchers.floatThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserServiceImpl userService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("User 데이터 가져오기 테스트")
    public void getUserInfo() throws Exception{
        // given
        UserDto userDto = new UserDto("FEA05030"
                                        , "yongho.jeon"
                                        , "전용호"
                                        , "1234"
                                        , "USER");

        given(userService.selectUserInfo("FEA05028")).willReturn(userDto);


        // when
        String uid = "FEA05028";
        MvcResult mvcResult = mockMvc.perform(get("/userInfo/get").param("uid", uid))
                .andExpect(status().isOk())
                .andReturn();

        // then
        verify(userService).selectUserInfo(uid);

        // 응답 본문 파싱
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println("Response Content: " + content);

        Assertions.assertEquals(content, content);
    }

    @Test
//    @Transactional
    @DisplayName("User 데이터 저장 테스트")
    public void setUserInfo() throws Exception{
         // given
        UserDto insertUserDto = new UserDto("FEA05031"
                                                , "jgh@naver.com"
                                                , "yGe"
                                                , "$2a$10$LTAzA2l0wEZi85s4Exni6.WHh9tigLc4YAyA4tGIUrl2ol/0PBNss"
                                                , "ADMIN");
        Mockito.when(userService.insertUserInfo(Mockito.any(UserDto.class))).thenReturn(true);

        UserDto updateUserDto = new UserDto("FEA05031"
                                                , "jgh@naver.com"
                                                , "yGeeee"
                                                , "$2a$10$LTAzA2l0wEZi85s4Exni6.WHh9tigLc4YAyA4tGIUrl2ol/0PBNss"
                                                , "USER");

        // when
        // 1. insert
        String insertJsonContent = objectMapper.writeValueAsString(insertUserDto);
        MvcResult insertMvcResult =  mockMvc.perform(MockMvcRequestBuilders.post("/userInfo/set")
                                            .contentType(MediaType.APPLICATION_JSON)
                                            .content(insertJsonContent))
                                            .andExpect(status().isOk()).andReturn();

        // select
        // equlas


        // 2. update
        String updateJsonContent = objectMapper.writeValueAsString(updateUserDto);
        MvcResult updateMvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/userInfo/set")
                                            .contentType(MediaType.APPLICATION_JSON)
                                            .content(updateJsonContent))
                                            .andExpect(status().isOk()).andReturn();

        // 1. insert 응답 본문 파싱
        System.out.println("insertMvcResult Response Content: " + insertMvcResult.getResponse().getContentAsString());

        // 2. update 응답 본문 파싱
        System.out.println("updateMvcResult Response Content: " + updateMvcResult.getResponse().getContentAsString());


        // then
        // verify(userService).insertUserInfo(Mockito.any(UserDto.class));
        verify(userService, Mockito.times(2)).insertUserInfo(Mockito.any(UserDto.class)); // Verify insertUserInfo method is called twice

    }


}