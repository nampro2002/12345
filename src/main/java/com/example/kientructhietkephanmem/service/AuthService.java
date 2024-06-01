package com.example.kientructhietkephanmem.service;

import com.example.kientructhietkephanmem.dto.LoginDTO;
import com.example.kientructhietkephanmem.entity.NguoiDung;
import com.example.kientructhietkephanmem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    UserRepository userRepository;

    public NguoiDung dangNhap(String phoneNumber, String password) {
        NguoiDung nguoiDung = userRepository.findBySoDienThoaiAndMatKhau(phoneNumber, password);
        return nguoiDung;
    }
}
