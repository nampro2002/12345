package com.example.kientructhietkephanmem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PhongChieu {
    @Id
    @GeneratedValue
    int id;

    @Column
    String tenPhong;

    @OneToMany(mappedBy = "phongChieu")
    List<LichChieu> lichChieus;
}
