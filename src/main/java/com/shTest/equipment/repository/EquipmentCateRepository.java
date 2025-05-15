package com.shTest.equipment.repository;

import com.shTest.entity.EquipmentCate;
import com.shTest.entity.EquipmentUsing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipmentCateRepository extends JpaRepository<EquipmentCate, Integer> {
}
