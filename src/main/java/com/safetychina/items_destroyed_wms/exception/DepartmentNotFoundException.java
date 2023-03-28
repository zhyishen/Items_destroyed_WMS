package com.safetychina.items_destroyed_wms.exception;

public class DepartmentNotFoundException extends RuntimeException{
    public DepartmentNotFoundException(Long id){
        super("无法找到编号为 " + id +" 的部门条目");
    }
}
