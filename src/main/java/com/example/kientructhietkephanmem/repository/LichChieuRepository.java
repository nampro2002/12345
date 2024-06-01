package com.example.kientructhietkephanmem.repository;

import com.example.kientructhietkephanmem.entity.LichChieu;
import com.example.kientructhietkephanmem.entity.Phim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LichChieuRepository extends JpaRepository<LichChieu, Integer> {

    @Query("SELECT lichChieu " +
            "FROM LichChieu AS lichChieu " +
            "JOIN FETCH lichChieu.veXemPhims AS veXemPhims " +
            "JOIN FETCH lichChieu.phongChieu " +
            "LEFT JOIN FETCH veXemPhims.donDatHangChiTiet " +
            "WHERE lichChieu.id = :id ")
    LichChieu findOneFetch(@Param("id") int id);
}
