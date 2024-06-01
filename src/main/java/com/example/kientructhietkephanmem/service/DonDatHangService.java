package com.example.kientructhietkephanmem.service;

import com.example.kientructhietkephanmem.entity.DonDatHang;
import com.example.kientructhietkephanmem.entity.DonDatHangChiTiet;
import com.example.kientructhietkephanmem.entity.NguoiDung;
import com.example.kientructhietkephanmem.entity.VeXemPhim;
import com.example.kientructhietkephanmem.repository.DonDatHangChiTietRepository;
import com.example.kientructhietkephanmem.repository.DonDatHangRepository;
import com.example.kientructhietkephanmem.repository.VeXemPhimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DonDatHangService {
    @Autowired
    DonDatHangRepository donDatHangRepository;

    @Autowired
    DonDatHangChiTietRepository donDatHangChiTietRepository;

    @Autowired
    VeXemPhimRepository veXemPhimRepository;

    public DonDatHang order(NguoiDung nguoiDung, List<Integer> veXemPhimIds) {
        List<VeXemPhim> veXemPhims = veXemPhimRepository.findAllById(veXemPhimIds);

        DonDatHang donDatHang = new DonDatHang();
        List<DonDatHangChiTiet> donDatHangChiTiets = new ArrayList<>();
        int tongGiaTien = 0;

        for(VeXemPhim veXemPhim: veXemPhims) {
            tongGiaTien += veXemPhim.getGiaTien();
            DonDatHangChiTiet donDatHangChiTiet = new DonDatHangChiTiet();
            donDatHangChiTiet.setId(null);
            donDatHangChiTiet.setGiaTien(veXemPhim.getGiaTien());
            donDatHangChiTiet.setVeXemPhim(veXemPhim);
            donDatHangChiTiets.add(donDatHangChiTiet);
            veXemPhim.setTrangThai(1);
        }

        donDatHang.setId(null);
        donDatHang.setNguoiDung(nguoiDung);
        donDatHang.setTongGiaTien(tongGiaTien);
        donDatHang.setThoiGianGiaoDich(new Date());
        donDatHang.setDonDatHangChiTiets(donDatHangChiTiets);
        this.donDatHangRepository.save(donDatHang);

        for(DonDatHangChiTiet donDatHangChiTiet : donDatHangChiTiets) {
            donDatHangChiTiet.setDonDatHang(donDatHang);
        }

        this.veXemPhimRepository.saveAll(veXemPhims);
        this.donDatHangChiTietRepository.saveAll(donDatHangChiTiets);

        return donDatHang;
    }
}
