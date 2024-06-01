package com.example.kientructhietkephanmem.repository;

import com.example.kientructhietkephanmem.entity.DonDatHangChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonDatHangChiTietRepository extends JpaRepository<DonDatHangChiTiet, Integer> {
}
