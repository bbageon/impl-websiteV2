package com.example.implwebsitev2.controller;

import com.example.implwebsitev2.domain.User;
import com.example.implwebsitev2.domain.WeeklyReport;
import com.example.implwebsitev2.domain.WriteReport;
import com.example.implwebsitev2.dto.CreateWriteReportDto;
import com.example.implwebsitev2.dto.WriteReportDto;
import com.example.implwebsitev2.repository.UserRepository;
import com.example.implwebsitev2.repository.WeeklyReportRepository;
import com.example.implwebsitev2.repository.WriteReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/write_report")
public class WriteReportController {
    private final WriteReportRepository writeReportRepository;
    private final UserRepository userRepository;
    private final WeeklyReportRepository weeklyReportRepository;

    @PostMapping("/create")
    public WriteReport writeReportSave(@RequestBody CreateWriteReportDto writeReportDto) {
        Optional<User> user = userRepository.findById(writeReportDto.getUser_id());
        Optional<WeeklyReport> weeklyReport = weeklyReportRepository.findById(writeReportDto.getWeekly_report_id());

        WriteReport writeReport = new WriteReport();
        writeReport.setWrite_id(writeReportDto.getWrite_id());
        writeReport.setProgram_name(writeReportDto.getProgram_name());
        writeReport.setAction_items(writeReportDto.getAction_items());
        writeReport.setPlanned_tasks(writeReportDto.getPlanned_tasks());
        writeReport.setNotes(writeReportDto.getNotes());
        writeReport.setUser(user.get());
        writeReport.setWeeklyReport(weeklyReport.get());

        return writeReportRepository.save(writeReport);
    }

    @GetMapping("/search")
    public List<WriteReport> getAll() {return writeReportRepository.findAll();}

    @GetMapping("/{id}")
    public WriteReportDto getOne(@PathVariable Long id) {
        WriteReport writeReport = writeReportRepository.findById(id).get();

        WriteReportDto writeReportDto = new WriteReportDto();

        writeReportDto.setWrite_id(writeReport.getWrite_id());
        writeReportDto.setProgram_name(writeReport.getProgram_name());
        writeReportDto.setAction_items(writeReport.getAction_items());
        writeReportDto.setPlanned_tasks(writeReport.getPlanned_tasks());
        writeReportDto.setNotes(writeReport.getNotes());
        writeReportDto.setUser(writeReport.getUser());
        writeReportDto.setWeekly_report(writeReport.getWeeklyReport());

        return writeReportDto;
    }
}
