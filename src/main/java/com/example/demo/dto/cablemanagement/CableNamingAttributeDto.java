package com.example.demo.dto.cablemanagement;

import com.example.demo.domain.entity.CableNamingEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Embedded;

@Data
@ToString
public class CableNamingAttributeDto {

    @JsonProperty("cableCode")
    private String cableCode;
    @JsonProperty("controlType")
    private String controlType;
    @JsonProperty("loadData")
    private String loadData;
    @JsonProperty("loadType")
    private String loadType;
    @JsonProperty("belong")
    private String belong;
    @JsonProperty("max")
    private String max;

    @Builder
    public CableNamingAttributeDto(String cableCode
                                    , String controlType
                                    , String loadData
                                    , String loadType
                                    , String belong
                                    , String max) {
        this.cableCode = cableCode;
        this.controlType = controlType;
        this.loadData = loadData;
        this.loadType = loadType;
        this.belong = belong;
        this.max = max;
    }

    public CableNamingAttributeDto(String controlType
                                    , String loadType) {
        this.controlType = controlType;
        this.loadType = loadType;
    }

    public CableNamingAttributeDto() {
    }
}
