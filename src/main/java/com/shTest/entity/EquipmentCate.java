package com.shTest.entity;

import com.shTest.equipment.dto.EquipmentCateDto;
import com.shTest.equipment.dto.EquipmentDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Equipment_Cate")
@Getter
@SequenceGenerator(
        name = "SEQ_EQP_CATE",
        sequenceName = "SEQ_EQP_CATE",
        initialValue = 261,
        allocationSize = 1

)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class EquipmentCate {
    @Id
    @Column(name = "EQPMNT_CATE_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQ_EQP_CATE")
    private int eqpCateNo;

    @Column(name = "EQPMNT_CATE_NM")
    private String eqpCateNm;

    @Column(name = "EQPMNT_CATE_DELYN")
    private String eqpCateDelyn = "N";

    @Column(name = "CH_NO")
    private int chNo = 95;

    public EquipmentCate(EquipmentCateDto eqpCateDto) {
        this.eqpCateNo = eqpCateDto.getEqpCateNo();
        this.eqpCateNm = eqpCateDto.getEqpCateNm();
    }

    public void EquipmentCateUpdate(String eqpCateNm) {
        this.eqpCateNm = eqpCateNm;
    }

    public void EquipmentCateDelete() {
        this.eqpCateDelyn = "Y";
    }
}
