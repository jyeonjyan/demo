package com.app.demo.response.result;

import com.app.demo.demo.dto.UserInfoDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    @DisplayName("ListResult가 정상적으로 생성된다.")
    void makeListResultSuccessfully(){
        /*
        Given
         */
        final UserInfoDto.UserInfoResponseDto mockUserInfoResponseDto = UserInfoDto.UserInfoResponseDto.builder()
                .id(1L)
                .username("jyeonjyan")
                .email("jyeonjyan.dev@gmail.com")
                .build();

        List<UserInfoDto.UserInfoResponseDto> userInfoResponseDtoList = new ArrayList<>();
        userInfoResponseDtoList.add(mockUserInfoResponseDto);

        /*
        When
         */
        final Result<UserInfoDto.UserInfoResponseDto> userInfoResponseDtoListResult =
                new ListResult<>(userInfoResponseDtoList, userInfoResponseDtoList.size());


        /*
        Then
         */
        assertNotNull(userInfoResponseDtoListResult);
        assertEquals(userInfoResponseDtoListResult.getData().size(), userInfoResponseDtoList.size());
    }

    @Test
    @DisplayName("singleResult를 위한 생성자 파라미터로 null이 들어오면 exception을 발생시킨다.")
    void nullDataCanNotProcess(){
        // Given
        String mockDataNull = null;
        // When
        assertThrows(IllegalArgumentException.class, () -> new Result<>(mockDataNull));
    }
}