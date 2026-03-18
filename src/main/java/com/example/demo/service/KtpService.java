package com.example.demo.service;

import com.example.demo.model.dto.KtpRequest;
import com.example.demo.model.dto.KtpResponse;

import java.util.List;

public interface KtpService {

    KtpResponse create(KtpRequest request);

    List<KtpResponse> getAll();

    KtpResponse getById(Integer id);

    KtpResponse update(Integer id, KtpRequest request);

    void delete(Integer id);
}
