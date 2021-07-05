package ru.gb.market.repositories;

import org.springframework.stereotype.Repository;
import ru.gb.market.product.Product;
import ru.gb.market.utils.NoProductException;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepo {
    private List<Product> productList;

    @PostConstruct
    public void init() {
        productList = new ArrayList<>();
        for (long i = 1L; i < 6; i++) {
            productList.add(new Product(i, "Product" + i, BigDecimal.valueOf(Math.random() * 30).setScale(2, RoundingMode.HALF_UP)));
        }
    }


    public List<Product> getProductList() {
        return Collections.unmodifiableList(productList);
    }

    public Product getProductById(Long id) throws NoProductException {
        for (Product p : productList) {
            if (p.getId() == id) return p;
        }
        throw new NoProductException();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

}
