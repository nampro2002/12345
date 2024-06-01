package com.example.kientructhietkephanmem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DonDatHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    int tongGiaTien;

    @Column
    Date thoiGianGiaoDich;

    @ManyToOne
    NguoiDung nguoiDung;

    @OneToMany(mappedBy = "donDatHang")
    List<DonDatHangChiTiet> donDatHangChiTiets;
}
