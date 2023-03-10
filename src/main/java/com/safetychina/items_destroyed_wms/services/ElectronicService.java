package com.safetychina.items_destroyed_wms.services;


import com.safetychina.items_destroyed_wms.Utils.StringToJsonUtil;
import com.safetychina.items_destroyed_wms.entity.ElectronicIn;
import com.safetychina.items_destroyed_wms.exception.ElectronicNotFoundException;
import com.safetychina.items_destroyed_wms.repository.ElectronicRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ElectronicService {

    private final ElectronicRepository electronicRepository;

    private final StringToJsonUtil stringToJsonUtil;

    public ElectronicService(ElectronicRepository electronicRepository, StringToJsonUtil stringToJsonUtil){
        this.electronicRepository = electronicRepository;
        this.stringToJsonUtil = stringToJsonUtil;
    }

    /**
     * 把所有的电子类项目进行列表
     * @return 返回所有的电子类项目
     */
    public List<ElectronicIn> getElectronics(){
        return electronicRepository.findAll();
    }

    public void addElectronic(ElectronicIn electronicIn){
        electronicRepository.save(electronicIn);
    }

    public ElectronicIn putElectronic(ElectronicIn newElectronicIn, Long id){
        return electronicRepository.findById(id)
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
                    return electronicRepository.save(electronicIn);
                })
                .orElseThrow(()->new ElectronicNotFoundException(id));
    }

    public void deleteElectronic(Long id){electronicRepository.deleteById(id);}

    public ElectronicIn getElectronic(Long id){
        return electronicRepository.findById(id)
                .orElseThrow(()->new ElectronicNotFoundException(id));
    }

    public String getElectronicTypes(){
        List<String> typeStrings = electronicRepository.getAllType();
        return stringToJsonUtil.stringToJsonString(typeStrings);
    }

    public String getElectronicSendDepartments(){
        List<String> departmentStrings = electronicRepository.getAllDepartment();
        return stringToJsonUtil.stringToJsonString(departmentStrings);
    }
    public String getElectronicRecipients(){
        List<String> recipientStrings = electronicRepository.getAllRecipient();
        return stringToJsonUtil.stringToJsonString(recipientStrings);
    }
    public String getElectronicTransferors(){
        List<String> transferorStrings = electronicRepository.getAllTransferor();
        return stringToJsonUtil.stringToJsonString(transferorStrings);
    }

    public String getElectronicPersonOfUses(){
        List<String> personOfUseStrings = electronicRepository.getAllPersonOfUse();
        return stringToJsonUtil.stringToJsonString(personOfUseStrings);
    }

}
