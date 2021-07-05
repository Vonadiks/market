package ru.gb.market.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.market.utils.NoProductException;
import ru.gb.market.product.Product;
import ru.gb.market.services.ProductService;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class RepoController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/show_repo")
    public String show(Model model) {
        List<Product> productList = productService.getProductList();
        model.addAttribute("productList", productList);
        return "repo_info";
    }

    @GetMapping("/product/{id}")
    public String showProductInfo(Model model, @PathVariable Long id) throws NoProductException {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product_info_view";
    }

    @GetMapping("/create_product_form")
    public String showCreateProductForm() {
        return "create_product_form";
    }

    @PostMapping("/create_product")
    public String createNewProduct(@RequestParam Long id, @RequestParam String title, @RequestParam String cost) {
        productService.addProduct(new Product(id, title, new BigDecimal(cost)));
        return "redirect:/show_repo";
    }
}
