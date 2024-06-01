package com.example.kientructhietkephanmem.repository;

import com.example.kientructhietkephanmem.entity.Phim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PhimRepository extends JpaRepository<Phim, Integer> {

    @Query("SELECT phim FROM Phim AS phim JOIN FETCH phim.lichChieus WHERE phim.id = :id")
    Phim findOneFetchLichChieu(@Param("id") int id);
}
