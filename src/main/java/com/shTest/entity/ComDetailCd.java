package com.shTest.entity;

import com.shTest.calendar.dto.CalendarDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "com_detail_cd")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ComDetailCd {

    @Id
    @Column(name = "COM_DETAIL_CD_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String comDetailCdId;

    @Column(name = "COM_CLSF_CD_ID")
    private String comClsfCdId;

    @Column(name = "COM_DETAIL_CD_NM")
    private String ComDetailCdNm;

    public ComDetailCd(CalendarDto calDto) {
        this.comDetailCdId = calDto.getSchdlCd();
        this.ComDetailCdNm = calDto.getComDetailCdNm();
    }
}
