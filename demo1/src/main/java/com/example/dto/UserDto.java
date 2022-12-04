package com.example.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserDto {

    private int id;
    private String userName;
    private String passWord;
    private String email;
    private String fullName;
    private int deptId;
    private String mobile;
    private String position;
    private int isDeleted;
    private Date createDate;
    private int role;
    private Integer status;
}
