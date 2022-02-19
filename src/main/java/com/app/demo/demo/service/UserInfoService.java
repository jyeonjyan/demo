package com.app.demo.demo.service;

import com.app.demo.demo.dto.UserInfoDto;
import com.app.demo.demo.entity.UserInfo;
import com.app.demo.demo.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserInfoService {

    private final UserInfoRepository userInfoRepository;

    public UserInfoDto.UserInfoResponseDto createUserInfo(UserInfoDto.UserInfoRequestDto userInfoRequestDto){
        UserInfo savedUserInfo = userInfoRepository.save(UserInfoDto.UserInfoRequestDto.toEntity(userInfoRequestDto));
        return UserInfoDto.UserInfoResponseDto.of(savedUserInfo);
    }

}
