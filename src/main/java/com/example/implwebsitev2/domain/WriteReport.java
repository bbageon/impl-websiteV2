package com.example.implwebsitev2.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.security.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class WriteReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long write_id;

    private String program_name;
    private String action_items;
    private String planned_tasks;
    private String notes;

    @Column
    @CreatedDate
    private LocalDateTime created_at;

    @Column
    @LastModifiedDate
    private LocalDateTime updated_at;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "weekly_report_id")
    @JsonIgnore
    private WeeklyReport weeklyReport;
}
