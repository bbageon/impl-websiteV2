package com.example.implwebsitev2.dto;

import lombok.Getter;

@Getter
public class CreateWriteReportDto {
    private Long write_id;

    private String program_name;
    private String action_items;
    private String planned_tasks;
    private String notes;

    private String user_id;
    private Long weekly_report_id;
}
