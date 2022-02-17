package com.app.demo.demo.controller;

import com.app.demo.demo.dto.UserInfoDto;
import com.app.demo.demo.entity.UserInfo;
import com.app.demo.demo.service.UserInfoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "user", description = "user related resources")
@RestController
@RequestMapping("/demo/v0.0.1/user")
@RequiredArgsConstructor
public class UserInfoController {

    private final UserInfoService userInfoService;

    @PostMapping("/userinfo")
    public ResponseEntity<UserInfo> createUserInfo(@RequestBody UserInfoDto.UserInfoRequestDto requestDto){
        final UserInfo userInfo = userInfoService.createUserInfo(requestDto);
        return ResponseEntity.ok(userInfo);
    }

}
