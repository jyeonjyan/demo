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

    public UserInfo createUserInfo(UserInfoDto.UserInfoRequestDto userInfoRequestDto){
        return userInfoRepository.save(userInfoRequestDto.toEntity(userInfoRequestDto));
    }

}
