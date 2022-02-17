package com.app.demo.demo.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity @Getter
@Table(name = "user_info")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder @AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserInfo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long userId;

    @Email @NotBlank
    @Column(name = "email")
    private String email;

    @NotBlank
    @Column(name = "password")
    private String password;

    @NotBlank
    @Column(name = "username")
    private String username;

}
