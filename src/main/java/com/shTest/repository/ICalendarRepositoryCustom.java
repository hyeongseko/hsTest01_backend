package com.shTest.repository;

import com.shTest.dto.CalendarDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ICalendarRepositoryCustom {
    List<CalendarDto> findAllCalendar();
}
