package com.example.umc9th.domain.test.converter;

import com.example.umc9th.domain.test.dto.res.TestResDTO;

public class TestConverter {

    // 객체 -> DTO
    public static TestResDTO.Testing toTestingDTO(
            String testString
    ) {
        return TestResDTO.Testing.builder()
                .testString(testString)
                .build();
    }

    // 객체 -> DTO
    public static TestResDTO.Exception toExceptionDTO(
            String testString
    ) {
        return TestResDTO.Exception.builder()
                .testString(testString)
                .build();
    }
}
