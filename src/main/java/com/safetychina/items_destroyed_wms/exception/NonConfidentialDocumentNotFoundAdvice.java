package com.safetychina.items_destroyed_wms.exception;


import com.safetychina.items_destroyed_wms.common.CommRes;
import com.safetychina.items_destroyed_wms.common.ResultCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class NonConfidentialDocumentNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(NonConfidentialDocumentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CommRes nonConfidentialDocumentNotFoundHandler(NonConfidentialDocumentNotFoundException nonConfidentialDocumentNotFoundException){
        return new CommRes(ResultCode.ENTITY_NOT_FOUND,nonConfidentialDocumentNotFoundException.getMessage());
    }
}
