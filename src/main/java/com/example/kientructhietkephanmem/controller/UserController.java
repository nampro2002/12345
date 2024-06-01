package com.example.kientructhietkephanmem.controller;

import com.example.kientructhietkephanmem.entity.NguoiDung;
import com.example.kientructhietkephanmem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @GetMapping("all")
    public String findUser(Model model, @RequestParam String name) {
        logger.info("Find By Name " + name);
        List<NguoiDung> nguoiDungList = userService.findUser(name);
        logger.info("All Users: " + nguoiDungList.size());
        model.addAttribute("users", nguoiDungList);
        return "timKiemKhachHang";
    }

    @GetMapping("{id}")
    public String detailUser(Model model, @PathVariable int id) {
        NguoiDung nguoiDung = userService.detailUser(id);
        return getString(model, nguoiDung);
    }

    @PostMapping("{id}")
    public String updateUser(Model model, @PathVariable int id,
         @RequestParam String hoTen,
         @RequestParam String ngaySinh,
         @RequestParam String diaChi
    ) throws ParseException {
        logger.info("NgaySinh", ngaySinh);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        NguoiDung nguoiDung = userService.updateUser(id, hoTen, diaChi, df.parse(ngaySinh));
        logger.info("UpdateUser: ", df.parse(ngaySinh));
        return getString(model, nguoiDung);
    }

    private String getString(Model model, NguoiDung nguoiDung) {
        Map<String, String> m = new HashMap<>();
        m.put("soDienThoai", nguoiDung.getSoDienThoai());
        m.put("hoTen", nguoiDung.getHoTen());
        m.put("ngaySinh", nguoiDung.getNgaySinh().toString());
        m.put("diaChi", nguoiDung.getDiaChi());
        model.addAllAttributes(m);
        model.addAttribute("customer", nguoiDung);

        return "thongTinKhachHang";
    }
}
