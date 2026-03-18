package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "ktp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ktp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nomor_ktp", unique = true)
    private String nomorKtp;

    @Column(name = "nama_lengkap")
    private String namaLengkap;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "tanggal_lahir")
    private LocalDate tanggalLahir;

    @Column(name = "jenis_kelamin")
    private String jenisKelamin;
}
