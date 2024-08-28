package com.example.onion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onion.entity.Manager;

public interface ManagerRepository extends JpaRepository<Manager, String> {
    // 매니저 ID로 매니저 정보를 조회하는 메서드
    Manager findByMid(String mid);
}
