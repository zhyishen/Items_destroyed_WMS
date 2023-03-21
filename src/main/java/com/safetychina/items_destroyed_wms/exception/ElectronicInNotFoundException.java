package com.safetychina.items_destroyed_wms.exception;

/**
 * @author zhyishen
 * @version 1.0
 * Create by 2023/1/21 12:40
 */
public class ElectronicInNotFoundException extends RuntimeException{
    public ElectronicInNotFoundException(Long id){
        super("无法找到编号为 " + id +" 的电子设备入库表");
    }
}
