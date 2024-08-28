package com.example.onion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onion.entity.UserInfo;

public interface UserRepository extends JpaRepository<UserInfo, String> {
	UserInfo findByUserid(String userid);
}
