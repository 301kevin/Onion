package com.example.onion.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import com.example.onion.dto.UserInfoDTO;

@Entity
@Table(name = "userInfo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    
    @Id
    private String userid;
    private String uname;
    private String upwd;
 //   private String urepwd;
    private String ugender;
    private String ujumin;
    private String utel1;
    private String utel2;
    private String utel3;
    private String uaddr;
    private String uemail1;
//   @Column(nullable = false)
    private String uemail2;
    private Date ulogtime;
    private char isActive;
    private Date lastLoginTime;
    private String profileImage;
    private String role;
    
    

    // Entity -> DTO 변환 메서드
//    public UserInfoDTO toDTO() {
//        return new UserInfoDTO(userid, uname, upwd, 
//        		ugender, ujumin, utel1, utel2, utel3, 
//        		uaddr, uemail1, uemail2, profileImage, ulogtime, 
//        		isActive, lastLoginTime, profileImage, role);
//    }
}

