package com.safetychina.items_destroyed_wms.exception;

import com.safetychina.items_destroyed_wms.common.CommRes;
import com.safetychina.items_destroyed_wms.common.ResultCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EntityNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ConfidentialDocumentInNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CommRes confidentialDocumentNotFoundHandler(ConfidentialDocumentInNotFoundException confidentialDocumentInNotFoundException){
        return new CommRes(ResultCode.ENTITY_NOT_FOUND, confidentialDocumentInNotFoundException.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(NonConfidentialDocumentInNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CommRes nonConfidentialDocumentNotFoundHandler(NonConfidentialDocumentInNotFoundException nonConfidentialDocumentInNotFoundException){
        return new CommRes(ResultCode.ENTITY_NOT_FOUND, nonConfidentialDocumentInNotFoundException.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(ElectronicInNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CommRes electronicNotFoundHandler(ElectronicInNotFoundException exception){
        return new CommRes(ResultCode.ENTITY_NOT_FOUND,exception.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(ConfidentialDocumentOutNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CommRes confidentialDocumentOutNotFoundHandler(ConfidentialDocumentOutNotFoundException confidentialDocumentOutNotFoundException){
        return new CommRes(ResultCode.ENTITY_NOT_FOUND, confidentialDocumentOutNotFoundException.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(NonConfidentialDocumentOutNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CommRes nonConfidentialDocumentOutNotFoundHandler(NonConfidentialDocumentOutNotFoundException nonConfidentialDocumentOutNotFoundException){
        return new CommRes(ResultCode.ENTITY_NOT_FOUND, nonConfidentialDocumentOutNotFoundException.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(ElectronicOutNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CommRes electronicOutNotFoundHandler(ElectronicOutNotFoundException electronicOutNotFoundException){
        return new CommRes(ResultCode.ENTITY_NOT_FOUND,electronicOutNotFoundException.getMessage());
    }
}
