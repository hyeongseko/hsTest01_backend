package com.shTest.controller;

import com.shTest.dto.CalendarDto;
import com.shTest.service.CalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cal")
public class CalendarController {

    private final CalendarService calService;

    @GetMapping("/list")
    public List<CalendarDto> calList() {
        return calService.calList();
    }

    @GetMapping("/gubunList")
    public List<CalendarDto> gubunList() throws Exception {
        return calService.gubunList();
    }

    @PostMapping("/find/{schdlNo}")
    public CalendarDto findId(@PathVariable("schdlNo") Long schdlNo) {
        return calService.findId(schdlNo);
    }

    @PostMapping("/insert")
    public void calInsert(@RequestBody CalendarDto calDto) throws Exception {
        calService.calInsert(calDto);
    }

    @PostMapping("/delete")
    public void calDelete(@RequestBody CalendarDto calDto) {
        calService.calDelete(calDto);
    }
}
