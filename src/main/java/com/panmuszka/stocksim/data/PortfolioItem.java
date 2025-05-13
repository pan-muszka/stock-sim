package com.panmuszka.stocksim.data;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;

@Entity
public class PortfolioItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Portfolio portfolio;

    @ManyToOne
    private Stock stock;

    private long quantity;

    public interface PortfolioItemRepository extends JpaRepository<PortfolioItem, Long> { }

    public PortfolioItem(long id, Portfolio portfolio, Stock stock, int quantity) {
        this.id = id;
        this.portfolio = portfolio;
        this.stock = stock;
        this.quantity = quantity;
    }

    public PortfolioItem() { }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public void addQuantity(long quantity) {
        this.quantity += quantity;
    }

    public void removeQuantity(long quantity) {
        if (quantity > this.quantity)
            return;

        this.quantity -= quantity;
    }
}
