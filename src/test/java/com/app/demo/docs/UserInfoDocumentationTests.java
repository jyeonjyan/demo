package com.app.demo.docs;

import com.app.demo.demo.dto.UserInfoDto;
import com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static com.app.demo.util.ApiDocumentUtils.getDocumentRequest;
import static com.app.demo.util.ApiDocumentUtils.getDocumentResponse;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs(uriScheme = "https", uriHost = "docs.api.com")
public class UserInfoDocumentationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    @DisplayName("uri: /demo/v0.0.1/user/userinfo 테스트하면 정상적으로 반환한다.")
    public void create() throws Exception {
        /*
        Given:: requestDto
         */
        UserInfoDto.UserInfoRequestDto requestDto = UserInfoDto.UserInfoRequestDto.builder()
                .email("jihwan.official@gmail.com")
                .password("1234")
                .username("jyeonjyan")
                .build();

        // When
        ResultActions result = this.mockMvc.perform(
                RestDocumentationRequestBuilders.post("/demo/v0.0.1/user/userinfo")
                        .content(objectMapper.writeValueAsString(requestDto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        );

        // Then
        result.andExpect(status().isCreated())
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