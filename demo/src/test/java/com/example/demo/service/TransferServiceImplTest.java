package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransferServiceImplTest {

    @Autowired
    private TransferService transferService;

    @Test
    public void testSuccessfulTransfer() {
        String response = transferService.transfer("492", "481", 200.0);
        assertEquals("Transfer successful!", response);
    }

    @Test
    public void testInsufficientBalance() {
        String response = transferService.transfer("492", "481", 2000.0);
        assertEquals("Insufficient balance.", response);
    }
}