package com.example.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)

public class ScheduleDto {
    private int id;

    private String scheduleDesc;

    private String createdBy;

    private Date createdDateTime;

    private int isDeleted;

    private int isVisible;

    private int isPublic;

    private int deptId;

    private int userId;

    private Date startDate;

    private int isSendByZaLO;

    private String departName;
}
