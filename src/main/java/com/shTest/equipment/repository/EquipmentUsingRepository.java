package com.shTest.equipment.repository;

import com.shTest.entity.ComDetailCd;
import com.shTest.entity.Equipment;
import com.shTest.entity.EquipmentUsing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipmentUsingRepository extends JpaRepository<EquipmentUsing, Integer> {
}
