package com.example.entity;


import com.example.dto.ScheduleDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "scheduleDesc")
    private String scheduleDesc;
    @Column(name = "createdBy")
    private String createdBy;
    @Column(name = "createdDateTime")
    private Date createdDateTime;
    @Column(name = "isDeleted")
    private int isDeleted;
    @Column(name = "isVisible")
    private int isVisible;
    @Column(name = "isPublic")
    private int isPublic;
    @Column(name = "deptId")
    private int deptId;
    @Column(name = "userId")
    private int userId;
    @Column(name = "startDate")
    private Date startDate;

    public static Schedule of(ScheduleDto dto) {
        Schedule obj = Schedule.builder()
                .scheduleDesc(dto.getScheduleDesc())
                .createdBy(dto.getCreatedBy())
                .createdDateTime(dto.getCreatedDateTime())
                .isDeleted(dto.getIsDeleted())
                .isVisible(dto.getIsVisible())
                .isPublic(dto.getIsPublic())
                .deptId(dto.getDeptId())
                .userId(dto.getUserId())
                .startDate(dto.getStartDate())
                .build();
        return obj;
    }

    public static ScheduleDto toDTO(Schedule dto) {
        ScheduleDto obj = ScheduleDto.builder()
                .id(dto.getId())
                .scheduleDesc(dto.getScheduleDesc())
                .createdBy(dto.getCreatedBy())
                .createdDateTime(dto.getCreatedDateTime())
                .isDeleted(dto.getIsDeleted())
                .isVisible(dto.getIsVisible())
                .isPublic(dto.getIsPublic())
                .deptId(dto.getDeptId())
                .userId(dto.getUserId())
                .startDate(dto.getStartDate())
                .build();
        return obj;
    }

    public ScheduleDto toDTO() {
        return Schedule.toDTO(this);
    }
}
