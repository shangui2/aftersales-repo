package com.demo.aftersales.controller;

import com.demo.aftersales.dto.RefundRequestDTO;
import com.demo.aftersales.service.OrderCoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/refund")
@RequiredArgsConstructor
public class RefundController {

    private final OrderCoreService orderCoreService;

    @PostMapping("/apply")
    public ResponseEntity<String> applyRefund(@RequestBody RefundRequestDTO requestDTO) {
        String result = orderCoreService.applyRefund(requestDTO);
        return ResponseEntity.ok(result);
    }
}
