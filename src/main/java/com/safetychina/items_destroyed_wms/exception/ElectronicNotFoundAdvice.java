package com.safetychina.items_destroyed_wms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author zhyishen
 * @version 1.0
 * Create by 2023/1/26 21:14
 */
public class ElectronicNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ElectronicNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String electronicNotFoundHandler(ElectronicNotFoundException exception){
        return exception.getMessage();
    }
}
