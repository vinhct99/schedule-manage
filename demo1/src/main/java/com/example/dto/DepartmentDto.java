package com.example.dto;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)

public class DepartmentDto {

    private int id;

    private String departmentName;

    private String createdBy;

    private String description;

    private int isDeleted;

    private int userId;
}
