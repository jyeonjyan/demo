package com.app.demo.demo.response;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.ResponseEntity;

/**
 * 적절한 ResponseEntity 를 만들기 위한 Template 클래스
 */
public class ResponseTemplate {

    /*
        response를 생성한다.
        TODO:: return type 변경
    */
    public ResponseEntity<RepresentationModel> createResponse(ResponseStrategy responseStrategy, Object data){
        return responseStrategy.createResponse(data);
    }

}
