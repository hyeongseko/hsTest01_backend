package com.shTest.calendar.repository;

import com.shTest.entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarRepository extends JpaRepository<Calendar, Long>  {
}
