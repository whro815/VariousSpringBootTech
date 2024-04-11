package com.example.demo.service.cablemanagement.Impl;

import com.example.demo.domain.entity.CableNamingEntity;
import com.example.demo.domain.repo.canlemanagement.CableNamingRepo;
import com.example.demo.dto.cablemanagement.CableNamingDto;
import com.example.demo.service.cablemanagement.CableProjectDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CableProjectDataServiceImpl implements CableProjectDataService {


    private final CableNamingRepo cableNamingRepo;

    @Transactional(readOnly = true)
    @Override
    public List<CableNamingDto> getCableNamingList(String pid, String uid) {
        List<CableNamingDto> cableNamingDtos = cableNamingRepo.findCableNamingList(pid);
        return cableNamingDtos;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean setVoltageDropList(CableNamingDto cableNamingDto) {
        try {
            cableNamingRepo.save(cableNamingDto.toEntity());
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteVoltageDropList(String pid, String uid) {
          try{

                List<CableNamingEntity> enList = new ArrayList<>();
//                cnids.forEach(a->{
//                    CableNamingDto info = cableNamingRepo.findCableDataInfo(a);
//                    if(info!=null){
//                        CableNamingEntity en = info.toEntity();
//                        en.setDel_yn("Y");
//                        en.setUid(uid);
//                        enList.add(en);
//                    }
//                });

        //      CableNamingDto info = cableNamingRepo.findCableDataInfo(a);
//                    if(info!=null){
//                        CableNamingEntity en = info.toEntity();
//                        en.setDel_yn("Y");
//                        en.setUid(uid);
//                        enList.add(en);
//                    }

               // CableNamingEntity en = info.toEntity();

                cableNamingRepo.saveAll(enList);

            return true;
        }catch(Exception e){

        }
        return false;
    }
}
