package com.example.onion.service;

import com.example.onion.entity.Manager;
import com.example.onion.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;
    
    public void save(Manager manager) {
        // 비밀번호 해시 등을 처리할 수 있음
        managerRepository.save(manager);
    }
    
    public Manager authenticate(String mid, String password) {
        Manager manager = managerRepository.findByMid(mid);

        if (manager != null && manager.getMpwd().equals(password)) {
            return manager;
        } else {
            return null; // 인증 실패 시 null 반환
        }
    }
}
