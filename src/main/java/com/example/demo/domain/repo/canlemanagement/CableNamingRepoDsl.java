package com.example.demo.domain.repo.canlemanagement;

import com.example.demo.dto.cablemanagement.CableNamingDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CableNamingRepoDsl {
    @Transactional(readOnly = true)
    List<CableNamingDto> findCableNamingList(String pid);

//    @Transactional(readOnly = true)
//    CableNamingDto findCableDataInfo(Long cdid);


}
