package ru.gb.market.product;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {
    private Long id;
    private String title;
    private BigDecimal cost;

    public Product(Long id, String title, BigDecimal cost) {
        this.id = id;
        this.title = title;
        this.cost = cost.setScale(2, RoundingMode.HALF_UP);
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}

