package com.app.demo.demo.controller;

import com.app.demo.demo.dto.UserInfoDto;
import com.app.demo.demo.response.ResponseService;
import com.app.demo.demo.response.SingleResultStrategy;
import com.app.demo.demo.service.UserInfoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "shorten-controller", description = "draft:: shorten-controller related responseService")
@RequestMapping("/demo/v0.0.1/shorten")
@RequiredArgsConstructor
@RestController
public class ShortenController {

    private final UserInfoService userInfoService;
    private final ResponseService responseService;

    @PostMapping("/userinfo")
    public ResponseEntity<Object> createUserInfo (@RequestBody UserInfoDto.UserInfoRequestDto requestDto){
        final UserInfoDto.UserInfoResponseDto userInfo = userInfoService.createUserInfo(requestDto);

        return responseService.createResponse(
                new SingleResultStrategy<>(new ShortenController(userInfoService, responseService), userInfo),
                userInfo.getId()
        );
    }


    /*
    TODO
     1. uri item:: createResponse(item.getId()) cause 비효율
     - 단건 까지는 괜찮은데 2번의 불편함을 초래
     2. stream을 써서 items를 내고 -> responseService를 만드는 부분에서 stream을 또 사용하는 비효율.
     */
    private List<String> makeLinks(List<UserInfoDto.UserInfoResponseDto> userInfoResponseDtoList){
        return null;
    }
}
