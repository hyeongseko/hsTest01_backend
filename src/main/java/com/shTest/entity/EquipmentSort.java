package com.shTest.entity;

import com.shTest.equipment.dto.EquipmentSortDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Entity
@Table(name="Equipment_Sort")
@Getter
@SequenceGenerator(
        name="SEQ_EQP_CATE",
        sequenceName = "SEQ_EQP_CATE",
        initialValue = 261,
        allocationSize = 1

)
@AllArgsConstructor
public class EquipmentSort {
    @Id
    @Column(name = "EQPMNT_CATE_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQ_EQP_CATE")
    private long eqpCateNo;

    @Column(name = "EQPMNT_CATE_NM")
    private String eqpCateNm;

    @Column(name = "EQPMNT_CATE_DELYN")
    private String eqpCateDelyn;

    public EquipmentSort(EquipmentSortDto eqpSortDto) {
        this.eqpCateNo = eqpSortDto.getEqpCateNo();
        this.eqpCateNm = eqpSortDto.getEqpCateNm();
        this.eqpCateDelyn = eqpSortDto.getEqpCateDelyn();
    }
}
