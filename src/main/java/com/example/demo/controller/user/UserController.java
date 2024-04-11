package com.example.demo.controller.user;

import com.example.demo.controller.BaseController;
import com.example.demo.dto.cablemanagement.CableNamingDto;
import com.example.demo.dto.user.UserDto;
import com.example.demo.resp.ResultResp;
import com.example.demo.service.user.UserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class UserController extends BaseController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/userInfo/list"
                , headers = { "Content-type=application/json" })
    public Map<String, Object> getUserInfo(@RequestParam(name = "uid")String uid) throws Exception{

        HashMap<String, Object> map = new HashMap<>();

        List<UserDto> userDtos = userService.selectUserInfo(uid);
        map.put("userInfoList", userDtos);

        return map;
	}


    @PostMapping(value = "/userInfo/set"
                , headers = { "Content-type=application/json" })
    public ResultResp setUserInfo(@RequestBody UserDto userDto)
            throws IOException {
        ResultResp resp = new ResultResp();
        boolean isOk = userService.insertUserInfo(userDto);

        if(!isOk){
         // ture 가 아닐때
            setMessage(resp, 403);
        }
        return resp;
    }




}
