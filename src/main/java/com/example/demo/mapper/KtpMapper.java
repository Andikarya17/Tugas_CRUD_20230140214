package com.example.demo.mapper;

import com.example.demo.model.dto.KtpRequest;
import com.example.demo.model.dto.KtpResponse;
import com.example.demo.model.entity.Ktp;
import org.springframework.stereotype.Component;

@Component
public class KtpMapper {

    public Ktp toEntity(KtpRequest request) {
        Ktp ktp = new Ktp();
        ktp.setNomorKtp(request.getNomorKtp());
        ktp.setNamaLengkap(request.getNamaLengkap());
        ktp.setAlamat(request.getAlamat());
        ktp.setTanggalLahir(request.getTanggalLahir());
        ktp.setJenisKelamin(request.getJenisKelamin());
        return ktp;
    }

    public KtpResponse toResponse(Ktp ktp) {
        return KtpResponse.builder()
                .id(ktp.getId())
                .nomorKtp(ktp.getNomorKtp())
                .namaLengkap(ktp.getNamaLengkap())
                .alamat(ktp.getAlamat())
                .tanggalLahir(ktp.getTanggalLahir())
                .jenisKelamin(ktp.getJenisKelamin())
                .build();
    }

    public void updateEntity(Ktp ktp, KtpRequest request) {
        ktp.setNomorKtp(request.getNomorKtp());
        ktp.setNamaLengkap(request.getNamaLengkap());
        ktp.setAlamat(request.getAlamat());
        ktp.setTanggalLahir(request.getTanggalLahir());
        ktp.setJenisKelamin(request.getJenisKelamin());
    }
}
