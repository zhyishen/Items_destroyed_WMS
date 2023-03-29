package com.safetychina.items_destroyed_wms.services;

import com.safetychina.items_destroyed_wms.entity.Equipment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ElectronicTypeService {

    List<Equipment> getElectronicTypes();

    void addElectronicType(Equipment equipment);

    void deleteElectronicType(Long id);

    Equipment putElectronicType(Equipment newEquipment, Long id);
}
