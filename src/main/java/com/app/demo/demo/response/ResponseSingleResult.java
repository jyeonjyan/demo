package com.app.demo.demo.response;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.ResponseEntity;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

public class ResponseSingleResult<C, M extends RepresentationModel> implements ResponseStrategy{

    private final C targetController;
    private final M targetModel;

    public ResponseSingleResult(C targetController, M targetModel) {
        this.targetController = targetController;
        this.targetModel = targetModel;
    }

    @Override
    public ResponseEntity<RepresentationModel> createResponse(Object data) {

        final var bodyContent = targetModel
                .add(Link.of(String.valueOf(linkTo(targetController.getClass())
                        .slash(data)
                        .toUri())).withSelfRel());

        return ResponseEntity.ok().body(bodyContent);
    }

}
