package com.example.kientructhietkephanmem.controller;

import com.example.kientructhietkephanmem.entity.Phim;
import com.example.kientructhietkephanmem.service.PhimServivce;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("movie")
public class PhimController {
    Logger logger = LoggerFactory.getLogger(PhimController.class);
    @Autowired
    PhimServivce phimServivce;

    @GetMapping("all")
    public String findAll(Model model) {
        List<Phim> phims = phimServivce.findAll();
        model.addAttribute("movies", phims);
        logger.info("Phims: " + phims.size());
        return "danhSachPhim";
    }

    @GetMapping("{id}")
    public String findOne(Model model, @PathVariable int id) {
        Phim phim = phimServivce.findOne(id);
        model.addAttribute("movie", phim);
        return "thongTinPhim";
    }
}
