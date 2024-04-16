package com.example.demo.domain.repo.canlemanagement;


import com.example.demo.domain.entity.cablemanagement.CableNamingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CableNamingRepo extends JpaRepository<CableNamingEntity, Long>, CableNamingRepoDsl{
    List<CableNamingEntity> findByPid(String pid);

}
