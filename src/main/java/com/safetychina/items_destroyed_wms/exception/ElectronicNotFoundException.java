package com.safetychina.items_destroyed_wms.exception;

/**
 * @author zhyishen
 * @version 1.0
 * Create by 2023/1/21 12:40
 */
public class ElectronicNotFoundException extends RuntimeException{
    public ElectronicNotFoundException(Long id){
        super("Could not find Electronic " + id);
    }
}
