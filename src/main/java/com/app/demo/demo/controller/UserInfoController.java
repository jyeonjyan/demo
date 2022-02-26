package com.app.demo.demo.controller;

import com.app.demo.demo.dto.UserInfoDto;
import com.app.demo.demo.service.UserInfoService;
import com.app.demo.response.ResultService;
import com.app.demo.response.result.Result;
import com.app.demo.response.strategy.SingleResultStrategy;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Tag(name = "user", description = "user related resources")
@RestController
@RequestMapping("/demo/v0.0.1/user")
@RequiredArgsConstructor
public class UserInfoController {

    private final UserInfoService userInfoService;
    private final ResultService resultService;

    @PostMapping("/userinfo")
    public Result<Object> createUserInfo(@RequestBody @Valid UserInfoDto.UserInfoRequestDto requestDto){
        final UserInfoDto.UserInfoResponseDto userInfo = userInfoService.createUserInfo(requestDto);

        /*
        hateoas:: "_links": "self": "href"
         */
        userInfo.add(
                Link.of(String.valueOf(linkTo(UserInfoController.class)
                        .slash(userInfo.getId()).toUri()))
                        .withSelfRel()
        );

        return resultService.createResult(new SingleResultStrategy(userInfo));
    }

    @GetMapping("/userinfo")
    public ResponseEntity<List<UserInfoDto.UserInfoResponseDto>> findAllUserInfo(){
        final List<UserInfoDto.UserInfoResponseDto> allUserInfo = userInfoService.getAllUserInfo();

        /*
        A userinfo 단위에 self-rel uri mapping
         */
        final List<UserInfoDto.UserInfoResponseDto> userInfoWithSelfRel = allUserInfo.stream()
                .map(userInfo -> userInfo.add(
                        Link.of(String.valueOf(linkTo(UserInfoController.class)
                                .slash(userInfo.getId()).toUri()))
                                .withSelfRel()
        )).collect(Collectors.toList());


        return ResponseEntity.ok().body(userInfoWithSelfRel);
    }
}
