package com.example.kientructhietkephanmem.controller;

import com.example.kientructhietkephanmem.entity.NguoiDung;
import com.example.kientructhietkephanmem.service.DonDatHangService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("order")
public class DonDatHangController {
    Logger logger = LoggerFactory.getLogger(DonDatHangController.class);
    @Autowired
    DonDatHangService donDatHangService;

    @PostMapping()
    public String order(HttpSession session, @RequestParam("selectedTickets") List<Integer> selectedTickets, Model model) {
        for(Integer i: selectedTickets) {
            logger.info("VeXemPhimId: " + i);
        }
        NguoiDung nguoiDung = (NguoiDung) session.getAttribute("user");
        this.donDatHangService.order(nguoiDung, selectedTickets);
        return "thanhToanDonDatHang";
    }
}
