package com.app.demo.docs;

import com.app.demo.demo.controller.UserInfoController;
import com.app.demo.demo.dto.UserInfoDto;
import com.app.demo.demo.service.UserInfoService;
import com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static com.app.demo.util.ApiDocumentUtils.getDocumentRequest;
import static com.app.demo.util.ApiDocumentUtils.getDocumentResponse;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserInfoController.class)
@AutoConfigureMockMvc
@AutoConfigureRestDocs(uriScheme = "https", uriHost = "docs.api.com")
public class UserInfoDocumentationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserInfoService userInfoService;


    @Test
    @DisplayName("create user info with spring rest docs api")
    public void create() throws Exception {
        // Given
        UserInfoDto.UserInfoRequestDto requestDto = UserInfoDto.UserInfoRequestDto.builder()
                .email("jihwan.official@gmail.com")
                .password("1234")
                .username("jyeonjyan")
                .build();

        given(userInfoService.createUserInfo(requestDto))
                .willReturn(UserInfoDto.UserInfoRequestDto.toEntity(requestDto));

        // When
        ResultActions result = this.mockMvc.perform(
                RestDocumentationRequestBuilders.post("/user/v1/api/userinfo")
                        .content(objectMapper.writeValueAsString(requestDto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        );

        // Then
        result.andExpect(status().isOk())
                .andDo(MockMvcRestDocumentationWrapper.document("userinfo-create",
                        getDocumentRequest(),
                        getDocumentResponse(),
                        requestFields(
                                fieldWithPath("email").type(JsonFieldType.STRING).description("이메일"),
                                fieldWithPath("password").type(JsonFieldType.STRING).description("비밀번호"),
                                fieldWithPath("username").type(JsonFieldType.STRING).description("사용자이름")
                        )
                ));
    }
}