package com.shTest.repository;

import com.shTest.entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ICalendarRepository extends JpaRepository<Calendar, Long> {
}
