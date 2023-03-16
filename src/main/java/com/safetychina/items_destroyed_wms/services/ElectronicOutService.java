package com.safetychina.items_destroyed_wms.services;

import com.safetychina.items_destroyed_wms.entity.ElectronicOut;

import java.util.List;

public interface ElectronicOutService {
    List <ElectronicOut> getElectronicOuts();

    void addElectronicOut(ElectronicOut electronicOut);


}
