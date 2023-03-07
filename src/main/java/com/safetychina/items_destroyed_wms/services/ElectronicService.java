package com.safetychina.items_destroyed_wms.services;


import com.google.gson.Gson;
import com.safetychina.items_destroyed_wms.entity.Electronic;
import com.safetychina.items_destroyed_wms.exception.ElectronicNotFoundException;
import com.safetychina.items_destroyed_wms.repository.ElectronicRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class ElectronicService {

    private final ElectronicRepository electronicRepository;

    public ElectronicService(ElectronicRepository electronicRepository){
        this.electronicRepository = electronicRepository;
    }

    /**
     * 把所有的电子类项目进行列表
     * @return 返回所有的电子类项目
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
                    electronic.setNotes(newElectronic.getNotes());
                    return electronicRepository.save(electronic);
                })
                .orElseThrow(()->new ElectronicNotFoundException(id));
    }

    public void deleteElectronic(Long id){electronicRepository.deleteById(id);}

    public Electronic getElectronic(Long id){
        return electronicRepository.findById(id)
                .orElseThrow(()->new ElectronicNotFoundException(id));
    }

    public String getElectronicJsonString(){
        List<String> typestrings = electronicRepository.getAllType();
        class Type{
            public Type(String value, String label){

            }
            private String value;
            private String label;
        }
        List<Type> typesItems = new ArrayList<Type>();
        for(String typestring : typestrings){
            Type typeItem = new Type(typestring,typestring);
            typesItems.add(typeItem);
        }

        Gson gson = new Gson();
        String typeJsonString = gson.toJson(typesItems).toString();

        return typeJsonString;
    }


}
