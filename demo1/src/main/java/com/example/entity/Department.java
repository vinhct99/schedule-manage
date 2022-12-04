package com.example.entity;

import com.example.dto.DepartmentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "departmentName")
    private String departmentName;
    @Column(name = "createdBy")
    private String createdBy;
    @Column(name = "description")
    private String description;
    @Column(name = "isDeleted")
    private int isDeleted;
    @Column(name = "userId")
    private int userId;
    public static Department of(DepartmentDto dto) {
        Department obj = Department.builder()
                .departmentName(dto.getDepartmentName())
                .createdBy(dto.getCreatedBy())
                .description(dto.getDescription())
                .isDeleted(dto.getIsDeleted())
                .userId(dto.getUserId())
                .build();
        return obj;
    }

    public static DepartmentDto toDTO(Department dto) {
        DepartmentDto obj = DepartmentDto.builder()
                .id(dto.getId())
                .departmentName(dto.getDepartmentName())
                .createdBy(dto.getCreatedBy())
                .description(dto.getDescription())
                .isDeleted(dto.getIsDeleted())
                .userId(dto.getUserId())
                .build();
        return obj;
    }

    public DepartmentDto toDTO() {
        return Department.toDTO(this);
    }
}
