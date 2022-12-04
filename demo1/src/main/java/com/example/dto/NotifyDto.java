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

public class NotifyDto {

    private int id;

    private String notifyContent;

    private int isVisible;

    private Date createdDate;

    private String createdBy;

    private int isDeleted;

    private int userId;
    private Integer roleNotify;
}
