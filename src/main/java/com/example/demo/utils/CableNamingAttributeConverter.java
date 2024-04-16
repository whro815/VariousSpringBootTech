package com.example.demo.utils;

import com.example.demo.dto.cablemanagement.CableNamingAttributeDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import javax.persistence.AttributeConverter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class CableNamingAttributeConverter implements AttributeConverter<List<CableNamingAttributeDto>, String> {

    public static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    }
    @Override
    public String convertToDatabaseColumn(List<CableNamingAttributeDto> attribute) {
        String customerInfoJson = null;
        try {
            customerInfoJson = objectMapper.writeValueAsString(attribute);
        } catch (final JsonProcessingException e) {
            e.printStackTrace();
        }
        return customerInfoJson;
    }

    @Override
    public List<CableNamingAttributeDto> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.trim().isEmpty()) {
            return Collections.emptyList();
        }
        List<CableNamingAttributeDto> attribute = Collections.emptyList();
        try {
            attribute = objectMapper.readValue(dbData, new TypeReference<List<CableNamingAttributeDto>>(){});
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return attribute;
    }
}
