package com.shTest.entity;

import com.shTest.equipment.dto.EquipmentDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "ATCH_FILE")
@Getter
@SequenceGenerator(
        name = "SEQ_ATCH",
        sequenceName = "SEQ_ATCH",
        initialValue = 1554,
        allocationSize = 1
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class AtachFile {

    @Id
    @Column(name = "ATCH_FILE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQ_ATCH")
    private int atchFileId;

    @Column(name = "ATCH_FILE_EXPLN")
    private String atchFileExpln = "equipment";

    @Column(name = "ATCH_FILE_REGDT")
    private Date atchFileRegDt = new Date();

    @Column(name = "ATCH_FILE_REMOVEDT")
    private String atchFileRemoveDt;

    public AtachFile(EquipmentDto eqpDto) {
        this.atchFileId = eqpDto.getAtchFileDto().getAtchFileId();
    }
}
