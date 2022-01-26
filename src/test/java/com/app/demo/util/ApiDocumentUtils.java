package com.app.demo.util;

import org.springframework.restdocs.operation.preprocess.OperationRequestPreprocessor;
import org.springframework.restdocs.operation.preprocess.OperationResponsePreprocessor;

import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;

public interface ApiDocumentUtils {
    /**
     * 문서의 request 를 예쁘게 출력하기 위해 사용합니다.
     */
    static OperationRequestPreprocessor getDocumentRequest(){
        return preprocessRequest(
                // make uris -> https://docs.api.com
                modifyUris()
                    .scheme("https")
                    .host("docs.api.com")
                    .removePort(),
                prettyPrint());
    }

    /**
     * 문서의 response 를 예쁘게 출력하기 위해 사용합니다.
     */
    static OperationResponsePreprocessor getDocumentResponse(){
        return preprocessResponse(prettyPrint());
    }
}
