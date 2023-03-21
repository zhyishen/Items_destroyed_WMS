package com.safetychina.items_destroyed_wms.services.impl;


import com.safetychina.items_destroyed_wms.Utils.StringToJsonUtil;
import com.safetychina.items_destroyed_wms.entity.ElectronicIn;
import com.safetychina.items_destroyed_wms.exception.ElectronicInNotFoundException;
import com.safetychina.items_destroyed_wms.repository.ElectronicInRepository;
import com.safetychina.items_destroyed_wms.services.ElectronicInService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectronicInServiceImpl implements ElectronicInService {

    private final ElectronicInRepository electronicInRepository;

    private final StringToJsonUtil stringToJsonUtil;

    public ElectronicInServiceImpl(ElectronicInRepository electronicInRepository, StringToJsonUtil stringToJsonUtil){
        this.electronicInRepository = electronicInRepository;
        this.stringToJsonUtil = stringToJsonUtil;
    }

    @Override
    public List<ElectronicIn> getElectronics(){
        return electronicInRepository.findAll();
    }
    @Override
    public void addElectronic(ElectronicIn electronicIn){
        electronicInRepository.save(electronicIn);
    }
    @Override
    public ElectronicIn putElectronic(ElectronicIn newElectronicIn, Long id){
        return electronicInRepository.findById(id)
                .map(electronicIn -> {
                    electronicIn.setQuantity(newElectronicIn.getQuantity());
                    electronicIn.setRecipient(newElectronicIn.getRecipient());
                    electronicIn.setTransferor(newElectronicIn.getTransferor());
                    electronicIn.setReceiveDate(newElectronicIn.getReceiveDate());
                    electronicIn.setSendDepartment(newElectronicIn.getSendDepartment());
                    electronicIn.setEquipmentName(newElectronicIn.getEquipmentName());
                    electronicIn.setPersonOfUse(newElectronicIn.getPersonOfUse());
                    electronicIn.setType(newElectronicIn.getType());
                    electronicIn.setSecretLevel(newElectronicIn.getSecretLevel());
                    electronicIn.setNotes(newElectronicIn.getNotes());
                    return electronicInRepository.save(electronicIn);
                })
                .orElseThrow(()->new ElectronicInNotFoundException(id));
    }
    @Override
    public void deleteElectronic(Long id){
        electronicInRepository.deleteById(id);}
    @Override
    public ElectronicIn getElectronic(Long id){
        return electronicInRepository.findById(id)
                .orElseThrow(()->new ElectronicInNotFoundException(id));
    }
    @Override
    public String getElectronicTypes(){
        List<String> typeStrings = electronicInRepository.getAllType();
        return stringToJsonUtil.stringToJsonString(typeStrings);
    }
    @Override
    public String getElectronicSendDepartments(){
        List<String> departmentStrings = electronicInRepository.getAllDepartment();
        return stringToJsonUtil.stringToJsonString(departmentStrings);
    }

    @Override
    public String getElectronicRecipients(){
        List<String> recipientStrings = electronicInRepository.getAllRecipient();
        return stringToJsonUtil.stringToJsonString(recipientStrings);
    }

    @Override
    public String getElectronicTransferors(){
        List<String> transferorStrings = electronicInRepository.getAllTransferor();
        return stringToJsonUtil.stringToJsonString(transferorStrings);
    }
    @Override
    public String getElectronicPersonOfUses(){
        List<String> personOfUseStrings = electronicInRepository.getAllPersonOfUse();
        return stringToJsonUtil.stringToJsonString(personOfUseStrings);
    }

}
