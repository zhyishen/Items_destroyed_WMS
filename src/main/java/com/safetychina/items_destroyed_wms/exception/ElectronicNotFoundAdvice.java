package com.safetychina.items_destroyed_wms.exception;

import com.safetychina.items_destroyed_wms.common.CommRes;
import com.safetychina.items_destroyed_wms.common.ResultCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zhyishen
 * @version 1.0
 * Create by 2023/1/26 21:14
 */
@RestControllerAdvice
public class ElectronicNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ElectronicNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CommRes electronicNotFoundHandler(ElectronicNotFoundException exception){
        return new CommRes(ResultCode.ENTITY_NOT_FOUND,exception.getMessage());
    }
}
