package com.safetychina.items_destroyed_wms.services;


import com.safetychina.items_destroyed_wms.Utils.StringToJsonUtil;
import com.safetychina.items_destroyed_wms.entity.Electronic;
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
