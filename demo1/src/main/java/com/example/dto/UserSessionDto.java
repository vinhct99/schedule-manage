package com.example.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class UserSessionDto {
    private int sessionId;

    private int userId;

    private Date createDate;

    private int isDeleted;
}
