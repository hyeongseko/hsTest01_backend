package com.shTest.equipment.repository;

import com.shTest.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, Integer>, EquipmentCustomRepository {
}
