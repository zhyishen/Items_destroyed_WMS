package com.safetychina.items_destroyed_wms.exception;

import com.safetychina.items_destroyed_wms.common.CommRes;
import com.safetychina.items_destroyed_wms.common.ResultCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ConfidentialDocumentNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ConfidentialDocumentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CommRes confidentialDocumentNotFoundHandler(ConfidentialDocumentNotFoundException confidentialDocumentNotFoundException){
        return new CommRes(ResultCode.ENTITY_NOT_FOUND,confidentialDocumentNotFoundException.getMessage());
    }
}
