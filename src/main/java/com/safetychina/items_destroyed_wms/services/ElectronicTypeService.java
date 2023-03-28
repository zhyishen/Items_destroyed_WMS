package com.safetychina.items_destroyed_wms.services;

import com.safetychina.items_destroyed_wms.entity.ElectronicType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ElectronicTypeService {

    List<ElectronicType> getElectronicTypes();

    void addElectronicType(ElectronicType electronicType);

    void deleteElectronicType(Long id);

    ElectronicType putElectronicType(ElectronicType newElectronicType, Long id);
}
