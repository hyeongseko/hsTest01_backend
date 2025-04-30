package com.shTest.repository;

import com.shTest.entity.Calendar;
import com.shTest.entity.ComDetailCd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {
}
