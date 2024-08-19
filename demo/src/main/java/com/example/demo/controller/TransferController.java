package com.example.demo.controller;

import com.example.demo.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transfer")
public class TransferController {

    private final TransferService transferService;

    @Autowired
    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping
    public ResponseEntity<String> transfer(@RequestParam String sourceAccountNumber,
                                           @RequestParam String destinationAccountNumber,
                                           @RequestParam double amount) {
        String response = transferService.transfer(sourceAccountNumber, destinationAccountNumber, amount);
        return ResponseEntity.ok(response);
    }
}

