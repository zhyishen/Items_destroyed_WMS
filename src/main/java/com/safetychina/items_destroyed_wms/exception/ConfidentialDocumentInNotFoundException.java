package com.safetychina.items_destroyed_wms.exception;

public class ConfidentialDocumentInNotFoundException extends RuntimeException{
    public ConfidentialDocumentInNotFoundException(Long id) {
        super("无法找到编号为 " + id +" 的涉密文件入库单");
    }
}
