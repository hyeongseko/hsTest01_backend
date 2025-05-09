package com.shTest.entity;

import com.shTest.equipment.dto.EquipmentDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Channel_Thread")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ChannelThread {
    @Id
    @Column(name = "TH_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int thNo;

    @Column(name = "TH_TTL")
    private String thTtl;


    public ChannelThread(EquipmentDto eqpDto) {
        this.thNo = eqpDto.getThNO();
        this.thTtl = eqpDto.getThTtl();
    }
}
