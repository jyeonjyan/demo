package com.app.demo.demo.response;

import org.springframework.http.ResponseEntity;

public interface ResponseStrategy {
    ResponseEntity<Object> createResponse(Object createdId);
}
