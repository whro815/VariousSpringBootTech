package com.example.demo.service.cablemanagement;


import com.example.demo.dto.cablemanagement.CableNamingDto;

import java.util.List;

public interface CableProjectDataService {
    List<CableNamingDto> getCableNamingList(String pid, String uid);

     boolean setVoltageDropList(CableNamingDto cableNamingDto);

     boolean deleteVoltageDropList(String pid, String uid);
}
