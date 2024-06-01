package com.example.kientructhietkephanmem.controller;

import com.example.kientructhietkephanmem.entity.LichChieu;
import com.example.kientructhietkephanmem.service.LichChieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("screening")
public class LichChieuController {
    @Autowired
    LichChieuService lichChieuService;

    @GetMapping("{id}")
    public String findOne(@PathVariable int id, Model model) {
        LichChieu lichChieu = lichChieuService.findOne(id);
        model.addAttribute("lichChieu", lichChieu);
        return "thongTinLichChieu";
    }
}
