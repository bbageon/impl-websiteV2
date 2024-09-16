package com.example.implwebsitev2.dto;

import com.example.implwebsitev2.domain.User;
import com.example.implwebsitev2.domain.WeeklyReport;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WriteReportDto {
    private Long write_id;

    private String program_name;
    private String action_items;
    private String planned_tasks;
    private String notes;

    private User user;
    private WeeklyReport weekly_report;
}
