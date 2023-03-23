package com.safetychina.items_destroyed_wms.exception;

public class CompanyNotFoundException extends RuntimeException{
    public CompanyNotFoundException(Long id){
        super("无法找到编号为 " + id +" 的部门条目");
    }
}
