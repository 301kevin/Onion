package com.example.onion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onion.entity.UserInfo;
import com.example.onion.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void save(UserInfo user) {
        // 비밀번호 해시 등을 처리할 수 있음
        userRepository.save(user);
    }
	
	public UserInfo authenticate(String userid, String password) {
		UserInfo user = userRepository.findByUserid(userid);

		if (user != null && user.getUpwd().equals(password)) {
			return user;
		} else {
			return null; // 인증 실패 시 null 반환
		}
	}
	
	public boolean isUseridExists(String userid) {
        return userRepository.findByUserid(userid) != null;
    }
}
