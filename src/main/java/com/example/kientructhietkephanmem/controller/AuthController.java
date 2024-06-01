package com.example.kientructhietkephanmem.controller;


import com.example.kientructhietkephanmem.entity.NguoiDung;
import com.example.kientructhietkephanmem.service.AuthService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class AuthController {
    @Autowired
    AuthService authService;

    @GetMapping()
    public String getDangNhap() {
        return "login";
    }

    @PostMapping()
    public String postDangNhap(@RequestParam String phoneNumber, @RequestParam String password, HttpSession session) {
        NguoiDung thanhVien = authService.dangNhap(phoneNumber, password);
        if(thanhVien == null) {
            LoggerFactory.getLogger(AuthService.class).info("Login Failed");
            return "login";
        }
        LoggerFactory.getLogger(AuthService.class).info("Login Success");
        session.setAttribute("user", thanhVien);

        if(thanhVien.getVaiTro().equals("ADMIN"))
            return "menuQuanLy";
        else
            return "menuKhachHang";
    }
}
