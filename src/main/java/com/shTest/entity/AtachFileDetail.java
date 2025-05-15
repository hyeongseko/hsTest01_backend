package com.shTest.entity;

import com.shTest.equipment.dto.EquipmentDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "ATCH_FILE_DETAIL")
@Getter
@SequenceGenerator(
        name = "SEQ_ATCH_DETAIL",
        sequenceName = "SEQ_ATCH_DETAIL",
        initialValue = 1188,
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

    @Column(name = "ATCH_FILE_SIZE")
    private long atchFileSize;

    @Column(name = "ATCH_FILE_ORGNL_NM")
    private String atchFileOrginNm;

    @Column(name = "ATCH_FILE_SAVE_NM")
    private String atchFileSaveNm;

    @Column(name = "ATCH_FILE_REGDT")
    private Date atchFileRegDt = new Date();

    @Column(name = "ATCH_FILE_REMOVE_YN")
    private String atchFileRemoveYn = "N";

    @Column(name = "ATCH_FILE_USE_YN")
    private String atchFileUseYn = "Y";


    public AtachFileDetail(EquipmentDto eqpDto) {
        this.atchDetailFileId = eqpDto.getAtchFileDto().getAtchDetailFileId();
        this.atchFileId = eqpDto.getAtchFileDto().getAtchFileId();
        this.atchFilePath = eqpDto.getAtchFileDto().getAtchFilePath();
        this.atchFileExtn = eqpDto.getAtchFileDto().getAtchFileExtn();
        this.atchFileSize = eqpDto.getAtchFileDto().getAtchFileSize();
        this.atchFileOrginNm = eqpDto.getAtchFileDto().getAtchFileOrginNm();
        this.atchFileSaveNm = eqpDto.getAtchFileDto().getAtchFilePath();
    }


}
