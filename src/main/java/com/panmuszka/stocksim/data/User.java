package com.panmuszka.stocksim.util;

import java.math.BigDecimal;

public class User {
    private long id;
    private String username;
    private BigDecimal balance;
    private Portfolio portfolio;

    public User(long id, String username, BigDecimal balance) {
        this.id = id;
        this.username = username;
        this.balance = balance;

        this.portfolio = new Portfolio();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        if (balance.compareTo(BigDecimal.ZERO) < 0)
            return;

        this.balance = balance;
    }
}
