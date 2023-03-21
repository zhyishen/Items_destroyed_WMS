package com.safetychina.items_destroyed_wms.services;

import com.safetychina.items_destroyed_wms.entity.ElectronicOut;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ElectronicOutService {
    List <ElectronicOut> getElectronicOuts();
    void addElectronicOut(ElectronicOut electronicOut);
    ElectronicOut putElectronicOut(ElectronicOut newElectronicOut, Long id);
    void deleteElectronicOut(Long id);
    ElectronicOut getElectronicOut(Long id);
}
