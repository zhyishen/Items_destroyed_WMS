package com.safetychina.items_destroyed_wms.exception;

public class ElectronicOutNotFoundException extends RuntimeException{
    public ElectronicOutNotFoundException(Long id){
        super("无法找到编号为 " + id +" 的电子设备出库表");
    }
}
