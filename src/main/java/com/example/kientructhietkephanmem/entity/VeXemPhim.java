package com.example.kientructhietkephanmem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VeXemPhim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    int giaTien;

    @Column
    String viTri;

    @Transient
    int trangThai;

    @ManyToOne
    LichChieu lichChieu;

    @OneToOne(mappedBy = "veXemPhim")
    DonDatHangChiTiet donDatHangChiTiet;
}
