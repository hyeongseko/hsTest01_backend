package com.shTest.entity;

import com.shTest.equipment.dto.EquipmentDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Channel_Member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @Column(name = "CH_MEM_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chMemNo;

    @Column(name = "CH_MEM_NM")
    private String chMemNm;
}
