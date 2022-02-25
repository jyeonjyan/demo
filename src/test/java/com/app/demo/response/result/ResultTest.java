package com.app.demo.response.result;

import com.app.demo.demo.dto.UserInfoDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
        final ListResult<UserInfoDto.UserInfoResponseDto> userInfoResponseDtoListResult =
                new ListResult<>(new Result<>(userInfoResponseDtoList), userInfoResponseDtoList.size());


        /*
        Then
         */
        assertNotNull(userInfoResponseDtoListResult);
        assertEquals(userInfoResponseDtoListResult.getResult().getData(), userInfoResponseDtoList);
        assertEquals(userInfoResponseDtoListResult.getSize(), userInfoResponseDtoList.size());
    }
}