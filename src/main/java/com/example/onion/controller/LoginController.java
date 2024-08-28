package com.example.onion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.example.onion.entity.UserInfo;
import com.example.onion.service.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/loginForm")
    public String showLoginForm() {
        return "member/login";  // 로그인 페이지를 반환
    }

    @PostMapping("/login")
    public RedirectView handleLogin(@RequestParam String userid, @RequestParam String password) {
        // 사용자 인증 로직
        UserInfo user = userService.authenticate(userid, password);
        
        if (user != null) {
            String role = user.getRole();
            String redirectUrl;
            
            // 역할에 따른 리다이렉션 URL 결정
            if (role.equals("ROLE_ADMIN")) {
                redirectUrl = "/admin/home";
            } else if (role.equals("ROLE_MANAGER")) {
                redirectUrl = "/manager/home";
            } else {
                redirectUrl = "/user/home";
            }
            
            return new RedirectView(redirectUrl);
        } else {
            // 인증 실패 시 로그인 페이지로 돌아가기
            return new RedirectView("/login?error=true");
        }
    }
}


