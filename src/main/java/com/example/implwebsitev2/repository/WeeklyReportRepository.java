package com.example.implwebsitev2.repository;

import com.example.implwebsitev2.domain.WeeklyReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeeklyReportRepository extends JpaRepository<WeeklyReport, Long> {
}
