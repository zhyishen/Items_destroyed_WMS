package com.safetychina.items_destroyed_wms.exception;

public class ElectronicTypeNotFoundException extends  RuntimeException{
    public ElectronicTypeNotFoundException(Long id) {
        super("无法找到编号为 " + id +" 的电子设备类型");
    }
}
