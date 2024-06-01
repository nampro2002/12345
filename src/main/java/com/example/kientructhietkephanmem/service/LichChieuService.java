package com.example.kientructhietkephanmem.service;

import com.example.kientructhietkephanmem.entity.DonDatHangChiTiet;
import com.example.kientructhietkephanmem.entity.LichChieu;
import com.example.kientructhietkephanmem.entity.VeXemPhim;
import com.example.kientructhietkephanmem.repository.LichChieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LichChieuService {
    @Autowired
    LichChieuRepository lichChieuRepository;

    public LichChieu findOne(int id) {
        LichChieu lichChieu = lichChieuRepository.findOneFetch(id);
        for(VeXemPhim veXemPhim : lichChieu.getVeXemPhims()) {
            DonDatHangChiTiet donDatHangChiTiet = veXemPhim.getDonDatHangChiTiet();
            int trangThai = (donDatHangChiTiet == null) ? 0 : 1;
            veXemPhim.setTrangThai(trangThai);
        }
        return lichChieu;
    }
}
