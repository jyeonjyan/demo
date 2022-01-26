package com.app.demo.demo.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
public class UserInfoDto {

    static class UserInfoRequestDto {
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
    }

}
