package com.safetychina.items_destroyed_wms.repository;

import com.safetychina.items_destroyed_wms.entity.ElectronicIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ElectronicInRepository extends JpaRepository<ElectronicIn, Long> {
    @Query("select distinct e.type FROM ElectronicIn e")
    List<String> getAllType();

    @Query("select distinct e.sendDepartment FROM ElectronicIn e")
    List<String> getAllDepartment();

    @Query("select  distinct e.recipient from ElectronicIn e")
    List<String> getAllRecipient();

    @Query("select  distinct e.transferor from ElectronicIn e")
    List<String> getAllTransferor();

    @Query("select  distinct e.personOfUse from ElectronicIn e")
    List<String> getAllPersonOfUse();
}