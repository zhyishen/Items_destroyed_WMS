package com.safetychina.items_destroyed_wms.services.impl;

import com.safetychina.items_destroyed_wms.entity.Equipment;
import com.safetychina.items_destroyed_wms.exception.ElectronicTypeNotFoundException;
import com.safetychina.items_destroyed_wms.repository.ElectronicTypeRepository;
import com.safetychina.items_destroyed_wms.services.ElectronicTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectronicTypeServiceImpl implements ElectronicTypeService {

    private final ElectronicTypeRepository electronicTypeRepository;

    public ElectronicTypeServiceImpl(ElectronicTypeRepository electronicTypeRepository) {
        this.electronicTypeRepository = electronicTypeRepository;
    }

    @Override
    public List<Equipment> getElectronicTypes() {
        return electronicTypeRepository.findAll();
    }

    @Override
    public void addElectronicType(Equipment equipment) {
        electronicTypeRepository.save(equipment);
    }

    @Override
    public void deleteElectronicType(Long id) {
        electronicTypeRepository.deleteById(id);
    }

    @Override
    public Equipment putElectronicType(Equipment newEquipment, Long id) {
        return electronicTypeRepository.findById(id).map(electronicType -> {
            electronicType.setTypeName(newEquipment.getTypeName());
            return electronicTypeRepository.save(electronicType);
        }).orElseThrow(()->new ElectronicTypeNotFoundException(id));
    }
}
