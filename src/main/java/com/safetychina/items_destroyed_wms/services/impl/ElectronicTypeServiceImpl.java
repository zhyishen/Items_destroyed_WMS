package com.safetychina.items_destroyed_wms.services.impl;

import com.safetychina.items_destroyed_wms.entity.ElectronicType;
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
    public List<ElectronicType> getElectronicTypes() {
        return electronicTypeRepository.findAll();
    }

    @Override
    public void addElectronicType(ElectronicType electronicType) {
        electronicTypeRepository.save(electronicType);
    }

    @Override
    public void deleteElectronicType(Long id) {
        electronicTypeRepository.deleteById(id);
    }

    @Override
    public ElectronicType putElectronicType(ElectronicType newElectronicType, Long id) {
        return electronicTypeRepository.findById(id).map(electronicType -> {
            electronicType.setTypeName(newElectronicType.getTypeName());
            return electronicTypeRepository.save(electronicType);
        }).orElseThrow(()->new ElectronicTypeNotFoundException(id));
    }
}
