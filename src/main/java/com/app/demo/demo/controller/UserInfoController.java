package com.app.demo.demo.controller;

import com.app.demo.demo.dto.UserInfoDto;
import com.app.demo.demo.entity.UserInfo;
import com.app.demo.demo.service.UserInfoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "user", description = "user related resources") // name == tag -> See tag-descriptions
@RestController
@RequestMapping("/user/v1/api") // /tag/version/api/**
@RequiredArgsConstructor
public class UserInfoController {

    private final UserInfoService userInfoService;

    @PostMapping("/userinfo")
    public UserInfo createUserInfo(@RequestBody UserInfoDto.UserInfoRequestDto requestDto){
        return userInfoService.createUserInfo(requestDto);
    }

}
