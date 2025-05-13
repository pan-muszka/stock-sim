package com.panmuszka.stocksim.data;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private User user;

    @OneToMany
    private List<PortfolioItem> holdings;

    public interface PorrtfolioRepository extends JpaRepository<Portfolio, Long> { }

    public Portfolio(long id, User user) {
        this.id = id;
        this.user = user;
        this.holdings = new ArrayList<PortfolioItem>();
    }

    public Portfolio() { }

    public void addStock(PortfolioItem stock) {
        for (PortfolioItem holding : this.holdings) {
            if (holding.getStock().equals(stock.getStock())) {
                holding.addQuantity(stock.getQuantity());
                return;
            }
        }
        this.holdings.add(stock);
    }

    public void removeStock(PortfolioItem stock) {
        for (PortfolioItem holding : this.holdings) {
            if (holding.getStock().equals(stock.getStock())) {
                holding.removeQuantity(stock.getQuantity());
                if (holding.getQuantity() == 0)
                    this.holdings.remove(holding);
                return;
            }
        }
    }

    public BigDecimal calculateHoldingsValue() {
        BigDecimal totalValue = BigDecimal.ZERO;

        for (PortfolioItem holding : this.holdings) {
            totalValue = totalValue.add(BigDecimal.valueOf(holding.getQuantity()));
        }

        return totalValue;
    }
}
