package com.example.kientructhietkephanmem.repository;

import com.example.kientructhietkephanmem.entity.DonDatHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonDatHangRepository extends JpaRepository<DonDatHang, Integer> {
}
