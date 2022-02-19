package com.app.demo.demo.controller;

import com.app.demo.demo.dto.UserInfoDto;
import com.app.demo.demo.entity.UserInfo;
import com.app.demo.demo.response.ResponseSingleResult;
import com.app.demo.demo.response.ResponseTemplate;
import com.app.demo.demo.service.UserInfoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Tag(name = "user", description = "user related resources")
@RestController
@RequestMapping("/demo/v0.0.1/user")
@RequiredArgsConstructor
public class UserInfoController {

    private final UserInfoService userInfoService;

    @PostMapping("/userinfo")
    public ResponseEntity<UserInfo> createUserInfo(@RequestBody UserInfoDto.UserInfoRequestDto requestDto){
        final UserInfo userInfo = userInfoService.createUserInfo(requestDto);

        /*
        hateoas:: "_links": "self": "href"
         */
        userInfo.add(
                Link.of(String.valueOf(linkTo(UserInfoController.class)
                        .slash(userInfo.getUserId())
                        .toUri())).withSelfRel()
        );

        return ResponseEntity
                .created(linkTo(UserInfoController.class)
                .slash(userInfo.getUserId()).toUri())
                .body(userInfo);
    }

    @PostMapping("/userinfo/template")
    public ResponseEntity<Object> createUserInfoWithTemplate(@RequestBody UserInfoDto.UserInfoRequestDto requestDto){
        final UserInfo userInfo = userInfoService.createUserInfo(requestDto);

        ResponseTemplate responseTemplate = new ResponseTemplate();
        return responseTemplate.createResponse(new ResponseSingleResult<>(new UserInfoController(userInfoService), userInfo), userInfo.getUserId());
    }
}
