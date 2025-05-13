package com.shTest.entity;

import com.shTest.equipment.dto.EquipmentDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ATCH_FILE")
@Getter
@SequenceGenerator(
        name = "SEQ_ATCH",
        sequenceName = "SEQ_ATCH",
        initialValue = 181,
        allocationSize = 1
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class AtachFile {

    @Id
    @Column(name = "ATCH_FILE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQ_ATCH")
    private int atchFileId;

    public AtachFile(EquipmentDto eqpDto) {
        this.atchFileId = eqpDto.getEqpFildId();
    }
}
