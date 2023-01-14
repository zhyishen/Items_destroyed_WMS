package com.safetychina.items_destroyed_wms.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NonConfidentialDocumentNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(NonConfidentialDocumentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String nonConfidentialDocumentNotFoundHandler(NonConfidentialDocumentNotFoundException exception){
        return exception.getMessage();
    }
}
