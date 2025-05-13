package com.panmuszka.stocksim.data;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Stock stock;

    public interface TransactionRepository extends JpaRepository<Transaction, Long> { }

    private TransactionType type;
    private int quantity;
    private BigDecimal pricePerShare;
    private LocalDateTime timestamp;

    public Transaction(long id, User user, Stock stock, TransactionType type, int quantity, BigDecimal pricePerShare) {
        this.id = id;
        this.user = user;
        this.stock = stock;
        this.type = type;
        this.quantity = quantity;
        this.pricePerShare = pricePerShare;
        this.timestamp = LocalDateTime.now();
    }

    public Transaction() {

    }
}
