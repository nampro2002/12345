package com.example.kientructhietkephanmem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
public class NguoiDung {
    public NguoiDung() {}

    @Id
    @GeneratedValue
    public int id;

    @Column(unique = true)
    String soDienThoai;

    @Column
    String matKhau;

    @Column
    String hoTen;

    @Column
    String diaChi;

    @Column
    String vaiTro;

    @Temporal(TemporalType.DATE)
    Date ngaySinh;

    @Column
    int trangThai;

    @OneToMany(mappedBy = "nguoiDung")
    List<DonDatHang> donDatHangList;

    @Transient
    int tongTienThongKe = 0;
}
