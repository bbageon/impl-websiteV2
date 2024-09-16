package com.example.implwebsitev2.controller;

import com.example.implwebsitev2.domain.WeeklyReport;
import com.example.implwebsitev2.repository.UserRepository;
import com.example.implwebsitev2.repository.WeeklyReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/weekly_report")
public class WeeklyReportController {
    private final WeeklyReportRepository weeklyReportRepository;

    @PostMapping("/create")
    public WeeklyReport weeklyReportSave(@RequestBody WeeklyReport weeklyReport) { return weeklyReportRepository.save(weeklyReport); }

    @GetMapping("/search")
    public List<WeeklyReport> getAllWeeklyReport() {return weeklyReportRepository.findAll();}

    @GetMapping("/{id}")
    public WeeklyReport getWeeklyReportById(@PathVariable Long id) {return weeklyReportRepository.findById(id).get();}
}
