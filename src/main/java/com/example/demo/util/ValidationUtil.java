package com.example.demo.util;

import com.example.demo.model.dto.KtpRequest;
import org.springframework.stereotype.Component;

@Component
public class ValidationUtil {

    public void validate(KtpRequest request) {
        // Validate nomorKtp
        if (request.getNomorKtp() == null || request.getNomorKtp().trim().isEmpty()) {
            throw new RuntimeException("Nomor KTP tidak boleh kosong");
        }
        if (!request.getNomorKtp().matches("\\d+")) {
            throw new RuntimeException("Nomor KTP hanya boleh angka");
        }
        if (request.getNomorKtp().length() != 16) {
            throw new RuntimeException("Nomor KTP harus 16 digit");
        }

        // Validate namaLengkap
        if (request.getNamaLengkap() == null || request.getNamaLengkap().trim().isEmpty()) {
            throw new RuntimeException("Nama lengkap tidak boleh kosong");
        }

        // Validate alamat
        if (request.getAlamat() == null || request.getAlamat().trim().isEmpty()) {
            throw new RuntimeException("Alamat tidak boleh kosong");
        }

        // Validate tanggalLahir (LocalDate, only null check)
        if (request.getTanggalLahir() == null) {
            throw new RuntimeException("Tanggal lahir tidak boleh kosong");
        }

        // Validate jenisKelamin
        if (request.getJenisKelamin() == null || request.getJenisKelamin().trim().isEmpty()) {
            throw new RuntimeException("Jenis kelamin tidak boleh kosong");
        }
    }
}
