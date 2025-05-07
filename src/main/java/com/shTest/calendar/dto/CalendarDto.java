package com.shTest.calendar.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.shTest.entity.Calendar;
import com.shTest.entity.ComDetailCd;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CalendarDto {
    private long schdlNo;
    private String schdlCd;
    private Date strtDt;
    private String start;
    private String stt;

    private Date endDt;
    private String end;
    private String edt;

    private String title;
    private String content;
    // color
    private String color;
    private Boolean allDay;
    private String btnNm;
    private int displayOrder;
    private String comDetailCdNm;

    public CalendarDto(Calendar calendar) {
        this.schdlNo = calendar.getSchdlNo();
        this.schdlCd = calendar.getSchdlCd();
        this.strtDt = calendar.getStrtDt();
        this.endDt = calendar.getEndDt();
        this.title = calendar.getSchdlTtl();
        this.content = calendar.getSchdlConts();
        this.color = calendar.getColor();
        this.allDay = calendar.getAllDay();
    }

    public CalendarDto ComDetailCd(ComDetailCd comDetailCd){
        CalendarDto calDto = new CalendarDto();
        calDto.setSchdlCd(comDetailCd.getComDetailCdId());
        calDto.setComDetailCdNm(comDetailCd.getComDetailCdNm());
        return calDto;
    }

}
