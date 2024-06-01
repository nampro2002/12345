package com.example.kientructhietkephanmem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @GetMapping()
    public String getPageDanhSachPhim() {
        return "danhSachPhim";
    }
}
