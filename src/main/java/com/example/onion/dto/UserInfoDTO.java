package com.example.onion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import com.example.onion.entity.UserInfo;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDTO {
    private String userid;
    private String uname;
    private String upwd;
  //  private String urepwd; // 비밀번호 확인 필드
    private String ugender;
    private String ujumin;
    private String utel1;
    private String utel2;
    private String utel3;
    private String uaddr;
    private String uemail1;
    private String uemail2;
    private Date ulogtime;
    private char isActive;
    private Date lastLoginTime;
    private String profileImage;
    private String role;

    // DTO -> Entity 변환 메서드
    public UserInfo toEntity() {
        return new UserInfo(userid, uname, upwd, ugender, ujumin, utel1, utel2, utel3, uaddr, uemail1, uemail2, ulogtime, isActive, lastLoginTime, profileImage, role);
    }
}
