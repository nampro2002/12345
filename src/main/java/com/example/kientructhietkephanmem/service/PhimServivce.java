package com.example.kientructhietkephanmem.service;

import com.example.kientructhietkephanmem.entity.LichChieu;
import com.example.kientructhietkephanmem.entity.NguoiDung;
import com.example.kientructhietkephanmem.entity.Phim;
import com.example.kientructhietkephanmem.repository.PhimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class PhimServivce {
    @Autowired
    PhimRepository phimRepository;

    public List<Phim> findAll() {
        return phimRepository.findAll();
    }

    public Phim findOne(int id) {
        Phim phim = this.phimRepository.findOneFetchLichChieu(id);
        return phim;
    }
}
