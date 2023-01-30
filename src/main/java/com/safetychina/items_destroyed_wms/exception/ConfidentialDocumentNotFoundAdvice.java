package com.safetychina.items_destroyed_wms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ConfidentialDocumentNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ConfidentialDocumentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String confidentialDocumentNotFoundHandler(ConfidentialDocumentNotFoundException confidentialDocumentNotFoundException){
        return confidentialDocumentNotFoundException.getMessage();
    }
}
