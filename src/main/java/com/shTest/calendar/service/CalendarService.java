package com.shTest.calendar.service;

import com.shTest.calendar.dto.CalendarDto;
import com.shTest.calendar.repository.CalendarRepository;
import com.shTest.calendar.repository.GubunRepository;
import com.shTest.entity.Calendar;
import com.shTest.entity.ComDetailCd;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class CalendarService {

    private final CalendarRepository calRep;
    private final GubunRepository gubunRep;

    public List<CalendarDto> calList() {
        List<Calendar> calendars = calRep.findAll();
        List<CalendarDto> calDtoList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        for (Calendar calEntCalendar : calendars) {
            calDtoList.add(new CalendarDto(calEntCalendar));
        }
        for (CalendarDto calList : calDtoList) {
            // 회사 - 부서 - 개인 일정순으로 정렬
            calList.setDisplayOrder(calList.getSchdlCd().equals("SCHST001") ? 3 : (calList.getSchdlCd().equals("SCHST002") ? 2 : 1));

            // 일정 출력은 Date 모달 날짜 칸은 String
            calList.setStart(sdf.format(calList.getStrtDt()));
            calList.setStt(sdf.format(calList.getStrtDt()).split(" ")[1]);
            calList.setEdt(sdf.format(calList.getEndDt()).split(" ")[1]);

            if (calList.getAllDay()) {
                // 종일 클릭시 전날 23:59분으로 입력되어 하루 추가
                calList.getEndDt().setDate(calList.getEndDt().getDate() + 1);
                calList.setEnd(sdf.format(calList.getEndDt()));
            } else {
                calList.setEnd(sdf.format(calList.getEndDt()));
            }
        }
        return calDtoList;
    }

    public List<CalendarDto> gubunList() {
        List<ComDetailCd> gubuns = gubunRep.findByComClsfCdIdContaining("SCHST");
        CalendarDto calDto = new CalendarDto();
        List<CalendarDto> gubunList = new ArrayList<>();
        for (ComDetailCd gubunEnt : gubuns) {
            gubunList.add(calDto.ComDetailCd(gubunEnt));
        }
        return gubunList;
    }

    public CalendarDto findId(Long schdlNo) {
        Calendar cal = calRep.findById(schdlNo).orElse(null);
        CalendarDto calDto = new CalendarDto(cal);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        // 모달에서는 String으로 날짜를 입력
        calDto.setStart(sdf.format(cal.getStrtDt()).split(" ")[0]);
        calDto.setStt(sdf.format(cal.getStrtDt()).split(" ")[1]);
        calDto.setEnd(sdf.format(cal.getEndDt()).split(" ")[0]);
        calDto.setEdt(sdf.format(cal.getEndDt()).split(" ")[1]);
        return calDto;
    }


    @Transactional
    public void calInsert(CalendarDto calDto) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        // EventResize + EventDrop 기능
        if (calDto.getBtnNm().equals("drop")) {
            // 하루가 넘어가면 allday: true
            if (calDto.getStrtDt().getMonth() == calDto.getEndDt().getMonth()) {
                // 같은달이면 날짜 비교
                if (calDto.getStrtDt().getDate() < calDto.getEndDt().getDate()) calDto.setAllDay(true);
            }
            // eventResize는 전날이 불가하니 다음달만 입력
            // 다음달이면 무조건 allday: true
            else {
                calDto.setAllDay(true);
            }
            // 종일 시에 하루가 추가되어 변경되어 전날로 등록
            if (calDto.getAllDay()) calDto.getEndDt().setDate(calDto.getEndDt().getDate() - 1);

            Calendar cal = calRep.findById(calDto.getSchdlNo()).orElse(null);
            cal.move(calDto.getStrtDt(), calDto.getEndDt(), calDto.getAllDay());
            calRep.save(cal);
        }
        // EventClick 기능
        else {
            // 하루가 넘어가면 allday: true
            // start > end는 등록시에 막음
            if (!sdf.parse(calDto.getStart() + " 00:00:00").equals(sdf.parse(calDto.getEnd() + " 00:00:00")))
                calDto.setAllDay(true);

            calDto.setStrtDt(sdf.parse(calDto.getStart() + " " + calDto.getStt()));
            calDto.setEndDt(sdf.parse(calDto.getEnd() + " " + calDto.getEdt()));
            Calendar calEnt = new Calendar(calDto);
            calRep.save(calEnt);
        }
    }

    @Transactional
    public void calDelete(CalendarDto calDto) {
        Calendar calEnt = new Calendar(calDto);
        calRep.delete(calEnt);
    }
}
