package com.safetychina.items_destroyed_wms.exception;

public class NonConfidentialDocumentNotFoundException extends RuntimeException{

    public NonConfidentialDocumentNotFoundException(Long id){
        super("无法找到编号为 " + id +" 的非涉密文件");
    }
}
