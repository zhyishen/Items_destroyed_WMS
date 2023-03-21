package com.safetychina.items_destroyed_wms.exception;

public class NonConfidentialDocumentInNotFoundException extends RuntimeException{

    public NonConfidentialDocumentInNotFoundException(Long id){
        super("无法找到编号为 " + id +" 的非涉密文件入库单");
    }
}
