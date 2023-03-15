package com.safetychina.items_destroyed_wms.services.impl;


import com.safetychina.items_destroyed_wms.Utils.StringToJsonUtil;
import com.safetychina.items_destroyed_wms.entity.ElectronicIn;
import com.safetychina.items_destroyed_wms.exception.ElectronicNotFoundException;
import com.safetychina.items_destroyed_wms.repository.ElectronicInRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ElectronicInServiceImpl {

    private final ElectronicInRepository electronicInRepository;

    private final StringToJsonUtil stringToJsonUtil;

    public ElectronicInServiceImpl(ElectronicInRepository electronicInRepository, StringToJsonUtil stringToJsonUtil){
        this.electronicInRepository = electronicInRepository;
        this.stringToJsonUtil = stringToJsonUtil;
    }

    /**
     * 把所有的电子类项目进行列表
     * @return 返回所有的电子类项目
     */
    public List<ElectronicIn> getElectronics(){
        return electronicInRepository.findAll();
    }

    public void addElectronic(ElectronicIn electronicIn){
        electronicInRepository.save(electronicIn);
    }

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
                .orElseThrow(()->new ElectronicNotFoundException(id));
    }

    public void deleteElectronic(Long id){
        electronicInRepository.deleteById(id);}

    public ElectronicIn getElectronic(Long id){
        return electronicInRepository.findById(id)
                .orElseThrow(()->new ElectronicNotFoundException(id));
    }

    public String getElectronicTypes(){
        List<String> typeStrings = electronicInRepository.getAllType();
        return stringToJsonUtil.stringToJsonString(typeStrings);
    }

    public String getElectronicSendDepartments(){
        List<String> departmentStrings = electronicInRepository.getAllDepartment();
        return stringToJsonUtil.stringToJsonString(departmentStrings);
    }
    public String getElectronicRecipients(){
        List<String> recipientStrings = electronicInRepository.getAllRecipient();
        return stringToJsonUtil.stringToJsonString(recipientStrings);
    }
    public String getElectronicTransferors(){
        List<String> transferorStrings = electronicInRepository.getAllTransferor();
        return stringToJsonUtil.stringToJsonString(transferorStrings);
    }

    public String getElectronicPersonOfUses(){
        List<String> personOfUseStrings = electronicInRepository.getAllPersonOfUse();
        return stringToJsonUtil.stringToJsonString(personOfUseStrings);
    }

}
