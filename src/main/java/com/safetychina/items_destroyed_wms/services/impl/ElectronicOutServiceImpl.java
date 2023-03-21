package com.safetychina.items_destroyed_wms.services.impl;

import com.safetychina.items_destroyed_wms.entity.ElectronicOut;
import com.safetychina.items_destroyed_wms.exception.ElectronicOutNotFoundException;
import com.safetychina.items_destroyed_wms.repository.ElectronicOutRepository;
import com.safetychina.items_destroyed_wms.services.ElectronicOutService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectronicOutServiceImpl implements ElectronicOutService {
    private final ElectronicOutRepository electronicOutRepository;

    public ElectronicOutServiceImpl(ElectronicOutRepository electronicOutRepository) {
        this.electronicOutRepository = electronicOutRepository;
    }

    @Override
    public List<ElectronicOut> getElectronicOuts() {
        return electronicOutRepository.findAll();
    }

    @Override
    public void addElectronicOut(ElectronicOut electronicOut) {
        electronicOutRepository.save(electronicOut);
    }

    @Override
    public ElectronicOut putElectronicOut(ElectronicOut newElectronicOut, Long id) {
        return electronicOutRepository.findById(id).map(electronicOut -> {
            electronicOut.setQuantity(newElectronicOut.getQuantity());
            electronicOut.setRecipient(newElectronicOut.getRecipient());
            electronicOut.setTransferor(newElectronicOut.getTransferor());
            electronicOut.setSendDepartment(newElectronicOut.getSendDepartment());
            electronicOut.setReceiveDepartment(newElectronicOut.getReceiveDepartment());
            electronicOut.setType(newElectronicOut.getType());
            electronicOut.setSecretLevel(newElectronicOut.getSecretLevel());
            electronicOut.setSendDate(newElectronicOut.getSendDate());
            return electronicOutRepository.save(electronicOut);
        }).orElseThrow(()->new ElectronicOutNotFoundException(id));
    }

    @Override
    public void deleteElectronicOut(Long id) {
        electronicOutRepository.deleteById(id);
    }

    @Override
    public ElectronicOut getElectronicOut(Long id) {
        return electronicOutRepository.findById(id).
                orElseThrow(()-> new ElectronicOutNotFoundException(id));
    }
}
