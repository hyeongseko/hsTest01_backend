package com.shTest.entity;

import com.shTest.equipment.dto.EquipmentDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Equipment_Sort")
@Getter
@SequenceGenerator(
        name="SEQ_EQP_CATE",
        sequenceName = "SEQ_EQP_CATE",
        initialValue = 261,
        allocationSize = 1

)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class EquipmentSort {
    @Id
    @Column(name = "EQPMNT_CATE_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQ_EQP_CATE")
    private int eqpCateNo;

    @Column(name = "EQPMNT_CATE_NM")
    private String eqpCateNm;

    @Column(name = "EQPMNT_CATE_DELYN")
    private String eqpCateDelyn;

    @Column(name="CH_NO")
    private int chNo;

    public EquipmentSort(EquipmentDto eqpDto) {
        this.eqpCateNo = eqpDto.getEqpCateNo();
        this.eqpCateNm = eqpDto.getEqpCateNm();
        this.eqpCateDelyn = eqpDto.getEqpCateDelyn();
    }
}
