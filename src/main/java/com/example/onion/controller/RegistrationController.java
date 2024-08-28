package com.example.onion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import com.example.onion.dto.UserInfoDTO;
import com.example.onion.entity.UserInfo;
import com.example.onion.service.UserService;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 회원가입 폼 페이지 반환
    @GetMapping("/registerForm")
    public String showRegistrationForm() {
        return "member/register"; // 회원가입 페이지를 반환
    }

    // 회원가입 처리
    @PostMapping("/register")
    public RedirectView registerUser(@ModelAttribute UserInfoDTO dto) {
    	System.out.println("userid: " + dto.getUserid());
        System.out.println("uname: " + dto.getUname());
        System.out.println("upwd: " + dto.getUpwd());
       // System.out.println("urepwd: " + dto.getUrepwd());
        System.out.println("ugender: " + dto.getUgender());
        System.out.println("uemail1: " + dto.getUemail1());
        System.out.println("uemail2: " + dto.getUemail2());
        System.out.println("utel1: " + dto.getUtel1());
        System.out.println("utel2: " + dto.getUtel2());
        System.out.println("utel3: " + dto.getUtel3());
        System.out.println("uaddr: " + dto.getUaddr());
        // 비밀번호 확인
        //if (dto.getUpwd() == null || dto.getUrepwd() == null || !dto.getUpwd().equals(dto.getUrepwd())) {
        //    throw new IllegalArgumentException("비밀번호가 일치하지 않거나 비밀번호가 비어 있습니다.");
        //}

        	System.out.println("dto : "+dto);
        // 아이디 중복 체크
        if (userService.isUseridExists(dto.getUserid())) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }
        
        dto.setUjumin("1");
        
        // 사용자 정보 저장
        UserInfo newUser = dto.toEntity();
        
        System.out.println(newUser);
        newUser.setUpwd(passwordEncoder.encode(dto.getUpwd())); // 비밀번호 암호화
        newUser.setRole("ROLE_USER"); // 기본 권한 설정

        userService.save(newUser);

        return new RedirectView("/login"); // 회원가입 후 로그인 페이지로 리다이렉트
    }
}
