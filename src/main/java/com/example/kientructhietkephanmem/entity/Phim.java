package com.example.kientructhietkephanmem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Phim {
    @Id
    @GeneratedValue
    int id;

    @Column
    String ten;

    @Column
    String moTa;

    @Column
    int thoiLuong;

    @Column
    String theLoai;

    @JsonIgnore
    @OneToMany(mappedBy = "phim", fetch = FetchType.LAZY)
    List<LichChieu> lichChieus;
}
