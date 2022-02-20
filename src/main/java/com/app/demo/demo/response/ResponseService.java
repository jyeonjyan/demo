package com.app.demo.demo.response;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * 적절한 ResponseEntity 를 만들기 위한 Template 클래스
 */
@Service
public class ResponseService {

    /*
        response를 생성하는 method

        - 종류
        1. singleResult
        TODO 2. listResult
    */
    public ResponseEntity<Object> createResponse(ResponseStrategy responseStrategy, Object data){
        return responseStrategy.createResponse(data);
    }

}
