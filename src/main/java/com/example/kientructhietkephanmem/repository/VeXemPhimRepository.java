package com.example.kientructhietkephanmem.repository;


import com.example.kientructhietkephanmem.entity.VeXemPhim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeXemPhimRepository extends JpaRepository<VeXemPhim, Integer> {
}
