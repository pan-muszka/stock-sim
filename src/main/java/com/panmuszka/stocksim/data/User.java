package com.panmuszka.stocksim.data;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private BigDecimal balance;

    @OneToOne
    private Portfolio portfolio;

    @OneToMany
    private List<Transaction> transactions;

    public interface UserRepository extends JpaRepository<User, Long> { }

    public User(long id, String username, BigDecimal balance, long portfolioId) {
        this.id = id;
        this.username = username;
        this.balance = balance;

        this.portfolio = new Portfolio(portfolioId, this);
    }

    public User() { }

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
