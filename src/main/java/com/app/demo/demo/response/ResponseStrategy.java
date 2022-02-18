package com.app.demo.demo.response;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.ResponseEntity;

public interface ResponseStrategy {
    ResponseEntity<RepresentationModel> createResponse(Object createdId);
}
