package com.example.entity;

import com.example.dto.NotifyDto;
import com.example.dto.UserDto;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Notify {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "notifyContent")
    private String notifyContent;
    @Column(name = "isVisible")
    private int isVisible;
    @Column(name = "createdDate")
    private Date createdDate;
    @Column(name = "createdBy")
    private String createdBy;
    @Column(name = "isDeleted")
    private int isDeleted;
    @Column(name = "userId")
    private int userId;
    public static Notify of(NotifyDto dto) {
        Notify obj = Notify.builder()
                .notifyContent(dto.getNotifyContent())
                .isVisible(dto.getIsVisible())
                .createdDate(dto.getCreatedDate())
                .createdBy(dto.getCreatedBy())
                .isDeleted(dto.getIsDeleted())
                .userId(dto.getUserId())
                .build();
        return obj;
    }

    public static NotifyDto toDTO(Notify dto) {
        NotifyDto obj = NotifyDto.builder()
                .id(dto.getId())
                .notifyContent(dto.getNotifyContent())
                .isVisible(dto.getIsVisible())
                .createdDate(dto.getCreatedDate())
                .createdBy(dto.getCreatedBy())
                .isDeleted(dto.getIsDeleted())
                .userId(dto.getUserId())
                .build();
        return obj;
    }

    public NotifyDto toDTO() {
        return Notify.toDTO(this);
    }
}
