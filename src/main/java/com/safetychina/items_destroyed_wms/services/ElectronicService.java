package com.safetychina.items_destroyed_wms.services;


import com.safetychina.items_destroyed_wms.entity.Electronic;
import com.safetychina.items_destroyed_wms.exception.ElectronicNotFoundException;
import com.safetychina.items_destroyed_wms.repository.ElectronicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ElectronicService {

    private final ElectronicRepository electronicRepository;

    public ElectronicService(ElectronicRepository electronicRepository){
        this.electronicRepository = electronicRepository;
    }

    /**
     *
     * @return
     */
    public List<Electronic> getElectronics(){
        return electronicRepository.findAll();
    }

    public void addElectronic(Electronic electronic){
        electronicRepository.save(electronic);
    }

    public Electronic putElectronic(Electronic newElectronic, Long id){
        return electronicRepository.findById(id)
                .map(electronic -> {
                    electronic.setQuantity(newElectronic.getQuantity());
                    electronic.setRecipient(newElectronic.getRecipient());
                    electronic.setTransferor(newElectronic.getTransferor());
                    electronic.setReceiveDate(newElectronic.getReceiveDate());
                    electronic.setSendDepartment(newElectronic.getSendDepartment());
                    electronic.setEquipmentName(newElectronic.getEquipmentName());
                    electronic.setPersonOfUse(newElectronic.getPersonOfUse());
                    electronic.setType(newElectronic.getType());
                    electronic.setSecretLevel(newElectronic.getSecretLevel());
                    return electronicRepository.save(electronic);
                })
                .orElseThrow(()->new ElectronicNotFoundException(id));
    }

    public void deleteElectronic(Long id){electronicRepository.deleteById(id);}

    public Electronic getElectronic(Long id){
        return electronicRepository.findById(id)
                .orElseThrow(()->new ElectronicNotFoundException(id));
    }



}
