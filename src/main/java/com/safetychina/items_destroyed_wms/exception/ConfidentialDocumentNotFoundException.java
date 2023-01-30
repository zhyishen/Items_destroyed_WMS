package com.safetychina.items_destroyed_wms.exception;

public class ConfidentialDocumentNotFoundException extends RuntimeException{
    public ConfidentialDocumentNotFoundException(Long id) {
        super("Could not find ConfidentialDocument " + id);
    }
}
