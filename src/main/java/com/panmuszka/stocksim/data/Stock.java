package com.panmuszka.stocksim.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String symbol;
    private String name;
    private BigDecimal price;

    public interface StockRepository extends JpaRepository<Stock, Long> { }

    public Stock(long id, String symbol, String name, BigDecimal price) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.price = price;
    }

    public Stock() { }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
