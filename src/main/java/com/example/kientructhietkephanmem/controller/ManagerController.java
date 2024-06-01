package com.example.kientructhietkephanmem.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManagerController {
    Logger logger = LoggerFactory.getLogger(ManagerController.class);

    @GetMapping("quanLyKhachHang")
    public String getPageQuanLyKhachHang() {
        logger.info("Go to QuanLyKhachHang");
        return "quanLyKhachHang";
    }

    @GetMapping("timKiemKhachHang")
    public String getPageTimKiemKhachHang() {
        logger.info("Go to TimKiemKhachHang");
        return "timKiemKhachHang";
    }
}
