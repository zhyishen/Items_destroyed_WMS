package com.safetychina.items_destroyed_wms.exception;

import com.safetychina.items_destroyed_wms.common.CommRes;
import com.safetychina.items_destroyed_wms.common.ResultCode;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Set;

@RestControllerAdvice
public class ValidationExceptionAdvice {

    //用于捕获@RequestParam/@PathVariable参数触发校验规则抛出的异常
    @ExceptionHandler(value = ConstraintViolationException.class)
    public CommRes handleConstraintViolationException(ConstraintViolationException e) {
        StringBuilder sb = new StringBuilder();
        Set<ConstraintViolation<?>> conSet = e.getConstraintViolations();
        for (ConstraintViolation<?> con : conSet) {
            String message = con.getMessage();
            sb.append(message).append(";");
        }
        return new CommRes(ResultCode.VALIDATE_ERROR,sb.toString());
    }

    //用于捕获@RequestBody类型参数触发校验规则抛出的异常
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public CommRes handleValidException(MethodArgumentNotValidException e) {
        StringBuilder sb = new StringBuilder();
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        if (!CollectionUtils.isEmpty(allErrors)) {
            for (ObjectError error : allErrors) {
                sb.append(error.getDefaultMessage()).append(";");
            }
        }
        return new CommRes(ResultCode.VALIDATE_ERROR,sb.toString());
    }

}
