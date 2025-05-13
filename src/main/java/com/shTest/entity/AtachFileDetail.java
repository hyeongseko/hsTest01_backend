package com.shTest.entity;

import com.shTest.equipment.dto.EquipmentDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ATCH_FILE_DETAIL")
@Getter
@SequenceGenerator(
        name = "SEQ_ATCH_DETAIL",
        sequenceName = "SEQ_ATCH_DETAIL",
        initialValue = 181,
        allocationSize = 1
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class AtachFileDetail {

    @Id
    @Column(name = "ATCH_DETAIL_FILE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQ_ATCH_DETAIL")
    private int atchDetailFileId;

    @Column(name = "ATCH_FILE_ID")
    private int atchFileId;

    @Column(name = "ATCH_FILE_PATH")
    private String atchFilePath;

    @Column(name = "ATCH_FILE_EXTN")
    private String atchFileExtn;

    @Column(name = "ATCH_FILE_ORGNL_NM")
    private String atchFileOrginNm;

    public AtachFileDetail(EquipmentDto eqpDto) {
        this.atchDetailFileId = eqpDto.getAtchDetailFileId();
        this.atchFileId = eqpDto.getEqpFildId();
        this.atchFilePath = eqpDto.getAtchFilePath();
        this.atchFileExtn = eqpDto.getAtchFileExtn();
        this.atchFileOrginNm = eqpDto.getAtchFileOrginNm();
    }
}
