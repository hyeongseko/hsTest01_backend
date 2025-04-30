package com.shTest.entity;

import com.shTest.dto.CalendarDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;


@Entity
@Table(name = "scheduler")
@Getter
@SequenceGenerator(
        name = "SEQ_CAL_GENERATOR",
        sequenceName = "SEQ_CAL",
        initialValue = 624,
        allocationSize = 1
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DynamicUpdate
public class Calendar {

    @Id
    @Column(name = "schdl_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQ_CAL_GENERATOR")
    private long schdlNo;

    @Column(name = "schdl_cd")
    private String schdlCd;

    @Column(name = "strt_dt")
    private Date strtDt;

    @Column(name = "end_dt")
    private Date endDt;

    @Column(name = "schdl_ttl")
    private String schdlTtl;

    @Column(name = "schdl_conts")
    private String schdlConts;

    @Column(name = "color")
    private String color;

    @Column(name = "allday")
    private Boolean allDay;

    public Calendar(CalendarDto calDto) {
        this.schdlNo = calDto.getSchdlNo();
        this.schdlCd = calDto.getSchdlCd();
        this.strtDt = calDto.getStrtDt();
        this.endDt = calDto.getEndDt();
        this.schdlTtl = calDto.getTitle();
        this.schdlConts = calDto.getContent();
        this.color = calDto.getColor();
        this.allDay = calDto.getAllDay();
    }

    public void move(Date strtDt, Date endDt, Boolean allDay){
        this.strtDt = strtDt;
        this.endDt = endDt;
        this.allDay = allDay;
    }
}
