package com.example.kientructhietkephanmem.repository;

import com.example.kientructhietkephanmem.entity.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<NguoiDung, Integer> {
    NguoiDung findBySoDienThoaiAndMatKhau(String soDienThoai, String matKhau);

    @Query("SELECT nguoiDung FROM NguoiDung nguoiDung WHERE nguoiDung.hoTen LIKE %:name%")
    List<NguoiDung> findAllByHoTenLike(@Param("name") String name);

    @Query("SELECT nguoiDung FROM NguoiDung nguoiDung " +
            "LEFT JOIN FETCH nguoiDung.donDatHangList " +
            "WHERE nguoiDung.vaiTro = \"CUSTOMER\"")
    List<NguoiDung> getAllNguoiDungFetchThongKe();

    @Query("SELECT nguoiDung FROM NguoiDung nguoiDung " +
            "JOIN FETCH nguoiDung.donDatHangList donDatHangList " +
            "WHERE nguoiDung.id = :id")
    NguoiDung getOneNguoiDungFetchThongKe(@Param("id") int id);
}
