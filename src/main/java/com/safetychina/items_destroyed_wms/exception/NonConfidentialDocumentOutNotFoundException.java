package com.safetychina.items_destroyed_wms.exception;

public class NonConfidentialDocumentOutNotFoundException extends RuntimeException{
    public NonConfidentialDocumentOutNotFoundException(Long id){
        super("无法找到编号为 " + id +" 的非涉密文件出库单");
    }
}
