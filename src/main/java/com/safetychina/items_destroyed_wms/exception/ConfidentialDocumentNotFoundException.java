package com.safetychina.items_destroyed_wms.exception;

public class ConfidentialDocumentNotFoundException extends RuntimeException{
    public ConfidentialDocumentNotFoundException(Long id) {
        super("无法找到编号为 " + id +" 的涉密文件");
    }
}
