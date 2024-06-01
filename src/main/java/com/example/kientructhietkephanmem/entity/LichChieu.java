package com.example.kientructhietkephanmem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LichChieu {
    @Id
    @GeneratedValue
    int id;

    @Temporal(TemporalType.DATE)
    Date ngayChieu;

    @Column
    Date thoiGianBatDau;

    @Column
    Date thoiGianKetThuc;

    @JsonIgnore
    @ManyToOne
    Phim phim;

    @JsonIgnore
    @ManyToOne
    PhongChieu phongChieu;

    @JsonIgnore
    @OneToMany(mappedBy = "lichChieu")
    List<VeXemPhim> veXemPhims;
}
