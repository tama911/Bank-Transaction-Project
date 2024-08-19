package com.example.demo.service;

import com.example.demo.model.Account;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TransferServiceImpl implements TransferService {

    private Map<String, Account> accounts = new HashMap<>();

    public TransferServiceImpl() {
        // Sample in-memory accounts
        accounts.put("492", new Account("492", 2000.0));
        accounts.put("481", new Account("481", 1300.0));
    }

    @Override
    public String transfer(String sourceAccountNumber, String destinationAccountNumber, double amount) {
        Account sourceAccount = accounts.get(sourceAccountNumber);
        Account destinationAccount = accounts.get(destinationAccountNumber);

        if (sourceAccount == null || destinationAccount == null) {
            return "Invalid account number.";
        }

        if (sourceAccount.getBalance() < amount) {
            return "Insufficient balance.";
        }

        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);

        return "Transfer successful!";
    }
}

