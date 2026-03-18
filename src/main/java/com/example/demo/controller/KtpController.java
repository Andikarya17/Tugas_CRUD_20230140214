package com.example.demo.controller;

import com.example.demo.model.dto.KtpRequest;
import com.example.demo.model.dto.KtpResponse;
import com.example.demo.service.KtpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ktp")
@RequiredArgsConstructor
public class KtpController {

    private final KtpService ktpService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody KtpRequest request) {
        try {
            KtpResponse response = ktpService.create(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<List<KtpResponse>> getAll() {
        List<KtpResponse> responses = ktpService.getAll();
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        try {
            KtpResponse response = ktpService.getById(id);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody KtpRequest request) {
        try {
            KtpResponse response = ktpService.update(id, request);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            ktpService.delete(id);
            return ResponseEntity.ok(Map.of("message", "Data berhasil dihapus"));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage()));
        }
    }
}
