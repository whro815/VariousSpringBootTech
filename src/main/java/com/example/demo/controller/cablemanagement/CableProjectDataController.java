package com.example.demo.controller.cablemanagement;

import com.example.demo.controller.BaseController;
import com.example.demo.dto.cablemanagement.CableNamingDto;
import com.example.demo.resp.ResultResp;

import com.example.demo.service.cablemanagement.CableProjectDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

@Slf4j
@RestController
public class CableProjectDataController extends BaseController {

    @Autowired
    private CableProjectDataService cableProjectDataService;

    @GetMapping(value = "/voltagedrop/list"
                , headers = { "Content-type=application/json" })
    public Map<String, Object> getVoltagedrop(@RequestParam(name = "pid")String pid
                                            , @RequestParam(name = "uid")String uid) throws Exception{

        HashMap<String, Object> map = new HashMap<>();

        List<CableNamingDto> cableNamingDtos = cableProjectDataService.getCableNamingList(pid, uid);
        map.put("getCableNamingList", cableNamingDtos);

        return map;
	}

    @PostMapping(value = "/voltagedrop/set"
                , headers = { "Content-type=application/json" })
    public ResultResp setVoltagedrop(@RequestBody CableNamingDto cableNamingDto) throws Exception {

       ResultResp resp = new ResultResp();

       boolean isOk = cableProjectDataService.setVoltageDropList(cableNamingDto);
       if(!isOk)
           setMessage(resp, 403);

       return resp;
    }

    @PostMapping(value = "/voltagedrop/delete"
                , headers = { "Content-type=application/json" })
    public ResultResp setUserInfo(@RequestParam(name = "pid")String pid
                                  , @RequestParam(name = "uid")String uid) throws IOException {
        ResultResp resp = new ResultResp();
        boolean isOk = cableProjectDataService.deleteVoltageDropList(pid, uid);

        if(!isOk){
         // ture 가 아닐때
            setMessage(resp, 403);
        }
        return resp;
    }


}
