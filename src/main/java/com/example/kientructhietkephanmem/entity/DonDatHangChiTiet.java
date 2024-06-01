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
public class DonDatHangChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    int giaTien;

    @ManyToOne
    DonDatHang donDatHang;

    @OneToOne
    VeXemPhim veXemPhim;
}
