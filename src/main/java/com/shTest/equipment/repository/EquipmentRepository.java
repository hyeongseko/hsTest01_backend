package com.shTest.equipment.repository;

import com.shTest.entity.Equipment;
import com.shTest.equipment.dto.EquipmentDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, Long>, EquipmentCustomRepository {
}
