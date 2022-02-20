package com.app.demo.demo.service;

import com.app.demo.demo.dto.UserInfoDto;
import com.app.demo.demo.entity.UserInfo;
import com.app.demo.demo.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserInfoService {

    private final UserInfoRepository userInfoRepository;

    public UserInfoDto.UserInfoResponseDto createUserInfo(UserInfoDto.UserInfoRequestDto userInfoRequestDto){
        UserInfo savedUserInfo = userInfoRepository.save(UserInfoDto.UserInfoRequestDto.toEntity(userInfoRequestDto));
        return UserInfoDto.UserInfoResponseDto.of(savedUserInfo);
    }

    public List<UserInfoDto.UserInfoResponseDto> getAllUserInfo(){
        final List<UserInfo> userInfoList = userInfoRepository.findAll();

        return userInfoList.stream()
                .map(UserInfoDto.UserInfoResponseDto::of)
                .collect(Collectors.toList());
    }

}
