package com.itproger.lesson_15.homework;

import com.itproger.lesson_15.homework.exceptions.WrongAccountException;
import com.itproger.lesson_15.homework.exceptions.WrongCurrencyException;
import com.itproger.lesson_15.homework.exceptions.WrongOperationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankApplication {

    private final List<Account> accounts = new ArrayList<Account>() {{
        add(new Account("accountId001", 100, "USD"));
        add(new Account("accountId002", 500, "EUR"));
        add(new Account("accountId003", 250, "HRV"));
        add(new Account("accountId004", 1000, "USD"));
        add(new Account("accountId005", 750, "USD"));
        add(new Account("accountId006", 50, "USD"));
    }};


    public void process(String accountId, int amount, String currency) throws Exception {
        accounts.stream()
                .filter(account -> account.getId().equals(accountId))
                .findAny()
                .orElseThrow(() -> new WrongAccountException("Account does not exist"));

        accounts.stream()
                .filter(account -> account.getId().equals(accountId))
                .filter(account -> account.getCurrency().equals(currency))
                .findAny()
                .orElseThrow(() -> new WrongCurrencyException("Account currency mismatch"));

        accounts.stream()
                .filter(account -> account.getId().equals(accountId))
                .filter(account -> account.getCurrency().equals(currency))
                .filter(account -> account.getBalance() >= amount)
                .findAny()
                .orElseThrow(() -> new WrongOperationException("Insufficient funds"));

        Account desiredAccount = accounts.stream()
                .filter(account -> account.getId().equals(accountId))
                .filter(account -> account.getCurrency().equals(currency))
                .filter(account -> account.getBalance() >= amount)
                .findAny()
                .orElseThrow();

        int randomInt = new Random().nextInt(2);

        if (randomInt == 1) {
            throw new Exception("Random processing failure");
        }

        desiredAccount.setBalance(desiredAccount.getBalance() - amount);
    }
}