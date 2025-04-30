package com.shTest.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "member")
@Getter
public class Member {
    @Id
    @Column(name = "mem_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memNo;

    @Column(length = 60, name = "mem_id", nullable = false)
    private String memId;

    @Column(name = "mem_name", nullable = true)
    private String memName;

    @Column(name = "mem_ph", nullable = true)
    private String memPhone;
}
