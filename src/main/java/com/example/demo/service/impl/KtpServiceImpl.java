package com.example.demo.service.impl;

import com.example.demo.mapper.KtpMapper;
import com.example.demo.model.dto.KtpRequest;
import com.example.demo.model.dto.KtpResponse;
import com.example.demo.model.entity.Ktp;
import com.example.demo.repository.KtpRepository;
import com.example.demo.service.KtpService;
import com.example.demo.util.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KtpServiceImpl implements KtpService {

    private final KtpRepository ktpRepository;
    private final KtpMapper ktpMapper;
    private final ValidationUtil validationUtil;

    @Override
    public KtpResponse create(KtpRequest request) {
        validationUtil.validate(request);

        Optional<Ktp> existing = ktpRepository.findByNomorKtp(request.getNomorKtp());
        if (existing.isPresent()) {
            throw new RuntimeException("Nomor KTP sudah ada");
        }

        Ktp ktp = ktpMapper.toEntity(request);
        Ktp saved = ktpRepository.save(ktp);
        return ktpMapper.toResponse(saved);
    }

    @Override
    public List<KtpResponse> getAll() {
        return ktpRepository.findAll()
                .stream()
                .map(ktpMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public KtpResponse getById(Integer id) {
        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));
        return ktpMapper.toResponse(ktp);
    }

    @Override
    public KtpResponse update(Integer id, KtpRequest request) {
        validationUtil.validate(request);

        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));

        // If nomorKtp is changed, validate uniqueness
        if (!ktp.getNomorKtp().equals(request.getNomorKtp())) {
            Optional<Ktp> duplicate = ktpRepository.findByNomorKtp(request.getNomorKtp());
            if (duplicate.isPresent()) {
                throw new RuntimeException("Nomor KTP sudah ada");
            }
        }

        ktpMapper.updateEntity(ktp, request);
        Ktp updated = ktpRepository.save(ktp);
        return ktpMapper.toResponse(updated);
    }

    @Override
    public void delete(Integer id) {
        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));
        ktpRepository.delete(ktp);
    }
}
