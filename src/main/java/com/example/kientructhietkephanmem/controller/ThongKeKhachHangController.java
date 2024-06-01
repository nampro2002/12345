package com.example.kientructhietkephanmem.controller;

import com.example.kientructhietkephanmem.entity.NguoiDung;
import com.example.kientructhietkephanmem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("thongKeKhachHang")
public class ThongKeKhachHangController {
    @Autowired
    UserService userService;

    @GetMapping("")
    public String getDanhSachThongKeKhachHang(Model model) {
        List<NguoiDung> nguoiDungList = this.userService.getAllNguoiDungFetchThongKe();
        model.addAttribute("users", nguoiDungList);
        return "thongKeKhachHang";
    }

    @GetMapping("{id}")
    public String getOneThongKeKhachHang(@PathVariable int id, Model model) {
        NguoiDung nguoiDung = this.userService.getOneNguoiDungFetchThongKe(id);
        model.addAttribute("customer", nguoiDung);
        return "thongTinThongKeKhachHang";
    }
}
