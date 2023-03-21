package com.safetychina.items_destroyed_wms.exception;

public class ConfidentialDocumentOutNotFoundException extends RuntimeException{
    public ConfidentialDocumentOutNotFoundException(Long id) {
        super("无法找到编号为 " + id +" 的涉密文件出库单");
    }
}
