package com.safetychina.items_destroyed_wms.repository;

import com.safetychina.items_destroyed_wms.entity.Electronic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ElectronicRepository extends JpaRepository<Electronic, Long> {
    @Query("select distinct e.type FROM Electronic e")
    List<String> getAllType();

    @Query("select distinct e.sendDepartment FROM Electronic e")
    List<String> getAllDepartment();

    @Query("select  distinct e.recipient from Electronic e")
    List<String> getAllRecipient();

    @Query("select  distinct e.transferor from Electronic e")
    List<String> getAllTransferor();

    @Query("select  distinct e.personOfUse from Electronic e")
    List<String> getAllPersonOfUse();
}