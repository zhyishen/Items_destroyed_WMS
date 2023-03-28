package com.safetychina.items_destroyed_wms.services;

import com.safetychina.items_destroyed_wms.entity.ElectronicIn;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ElectronicInService {

    List<ElectronicIn> getElectronics();

    void addElectronic(ElectronicIn electronicIn);

    ElectronicIn putElectronic(ElectronicIn newElectronicIn, Long id);

    void deleteElectronic(Long id);

    ElectronicIn getElectronic(Long id);

    String getElectronicRecipients();

    String getElectronicPersonOfUses();
}
