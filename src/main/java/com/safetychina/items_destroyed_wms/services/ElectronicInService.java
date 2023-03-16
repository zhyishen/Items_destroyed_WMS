package com.safetychina.items_destroyed_wms.services;

import com.safetychina.items_destroyed_wms.entity.ElectronicIn;

import java.util.List;

public interface ElectronicInService {

    List<ElectronicIn> getElectronics();

    void addElectronic(ElectronicIn electronicIn);

    ElectronicIn putElectronic(ElectronicIn newElectronicIn, Long id);

    void deleteElectronic(Long id);

    ElectronicIn getElectronic(Long id);

    String getElectronicTypes();

    String getElectronicSendDepartments();

    String getElectronicRecipients();

    String getElectronicTransferors();

    String getElectronicPersonOfUses();
}
