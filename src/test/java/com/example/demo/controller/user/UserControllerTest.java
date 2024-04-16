package com.example.demo.controller.user;

import com.example.demo.dto.user.UserDto;
import com.example.demo.service.user.impl.UserServiceImpl;
import com.sun.source.tree.AssertTree;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserServiceImpl userService;

    @Test
    @DisplayName("User 데이터 가져오기 테스트")
    public void getUserInfo() throws Exception{


        // given
        UserDto userDto = new UserDto("FEA05030"
                                        , "yongho.jeon"
                                        , "$2a$10$LTAzA2l0wEZi85s4Exni6.WHh9tigLc4YAyA4tGIUrl2ol/0PBNzi"
                                        , "전용호"
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

}