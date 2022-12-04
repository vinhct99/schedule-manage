package com.example.entity;

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
@Table(name = "`User`")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "userName")
    private String userName;
    @Column(name = "passWord")
    private String passWord;
    @Column(name = "email")
    private String email;
    @Column(name = "fullName")
    private String fullName;
    @Column(name = "deptId")
    private int deptId;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "position")
    private String position;
    @Column(name = "isDeleted")
    private int isDeleted;
    @Column(name = "createDate")
    private Date createDate;
    @Column(name = "role")
    private int role;
    @Column(name = "status")
    private int status;

    public static User of(UserDto dto) {
        User obj = User.builder()
                .userName(dto.getUserName())
                .passWord(dto.getPassWord())
                .email(dto.getEmail())
                .fullName(dto.getFullName())
                .deptId(dto.getDeptId())
                .mobile(dto.getMobile())
                .position(dto.getPosition())
                .isDeleted(dto.getIsDeleted())
                .createDate(dto.getCreateDate())
                .role(dto.getRole())
                .status(dto.getStatus())
                .build();
        return obj;
    }

    public static UserDto toDTO(User dto) {
        UserDto obj = UserDto.builder()
                .userName(dto.getUserName())
                .passWord(dto.getPassWord())
                .email(dto.getEmail())
                .fullName(dto.getFullName())
                .deptId(dto.getDeptId())
                .mobile(dto.getMobile())
                .position(dto.getPosition())
                .isDeleted(dto.getIsDeleted())
                .createDate(dto.getCreateDate())
                .role(dto.getRole())
                .status(dto.getStatus())
                .build();
        return obj;
    }

    public UserDto toDTO() {
        return User.toDTO(this);
    }
}
