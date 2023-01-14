package com.safetychina.items_destroyed_wms.exception;

public class NonConfidentialDocumentNotFoundException extends RuntimeException{

    public NonConfidentialDocumentNotFoundException(Long id){

        super("Could not find nonConfidentialDocument" + id);
    }
}
