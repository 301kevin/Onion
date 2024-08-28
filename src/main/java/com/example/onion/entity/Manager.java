package com.example.onion.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import com.example.onion.dto.ManagerDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "manager")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manager {
    
    @Id
    private String mid;
    
    private String mpwd;
    private Date mlogtime;
    private String role;

    // Entity -> DTO 변환 메서드
    public ManagerDTO toDTO() {
        return new ManagerDTO(mid, mpwd, mlogtime, role);
    }
}

