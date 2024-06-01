package com.example.kientructhietkephanmem.service;

import com.example.kientructhietkephanmem.entity.DonDatHang;
import com.example.kientructhietkephanmem.entity.NguoiDung;
import com.example.kientructhietkephanmem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<NguoiDung> findUser(String name) {
        return userRepository.findAllByHoTenLike(name);
    }

    public NguoiDung detailUser(int id) {
        Optional<NguoiDung> nguoiDung = userRepository.findById(id);
        if(nguoiDung.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity_not_found"
            );
        }
        return nguoiDung.get();
    }

    public NguoiDung updateUser(int id, String hoTen, String diaChi, Date ngaySinh) {
        NguoiDung nguoiDung = this.detailUser(id);
        nguoiDung.setHoTen(hoTen);
        nguoiDung.setDiaChi(diaChi);
        nguoiDung.setNgaySinh(ngaySinh);
        nguoiDung = userRepository.save(nguoiDung);
        return nguoiDung;
    }


    public List<NguoiDung> getAllNguoiDungFetchThongKe() {
        List<NguoiDung> nguoiDungs = this.userRepository.getAllNguoiDungFetchThongKe();
        for(NguoiDung nguoiDung : nguoiDungs) {
            this.setThongKeNguoiDung(nguoiDung);
        }
        return nguoiDungs;
    }

    public NguoiDung getOneNguoiDungFetchThongKe(int id) {
        NguoiDung nguoiDung = this.userRepository.getOneNguoiDungFetchThongKe(id);
        this.setThongKeNguoiDung(nguoiDung);
        return nguoiDung;
    }

    private void setThongKeNguoiDung(NguoiDung nguoiDung) {
        int tongTienThongKe = 0;
        for(DonDatHang donDatHang: nguoiDung.getDonDatHangList()) {
            tongTienThongKe += donDatHang.getTongGiaTien();
        }
        nguoiDung.setTongTienThongKe(tongTienThongKe);
    }
}
