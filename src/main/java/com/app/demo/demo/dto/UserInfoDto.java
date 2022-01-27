package com.app.demo.demo.dto;

import com.app.demo.demo.entity.UserInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
public class UserInfoDto {

    @Getter
    @NoArgsConstructor
    public static class UserInfoRequestDto {
        @Email
        @NotBlank
        private String email;

        @NotBlank
        private String password;

        @NotBlank
        private String username;

        @Builder
        public UserInfoRequestDto(String email, String password, String username) {
            this.email = email;
            this.password = password;
            this.username = username;
        }

        public static UserInfo toEntity(UserInfoRequestDto userInfoRequestDto){
            return UserInfo.builder()
                    .email(userInfoRequestDto.getEmail())
                    .username(userInfoRequestDto.getUsername())
                    .password(userInfoRequestDto.getPassword())
                    .build();
        }
    }

}
