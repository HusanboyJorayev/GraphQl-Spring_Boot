package org.example.graphql.controller;

import lombok.RequiredArgsConstructor;
import org.example.graphql.entity.Product;
import org.example.graphql.service.ProductService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @QueryMapping()
    public List<Product> getAll() {
        return this.productService.getAllProduct();
    }

    @QueryMapping()
    public Product getProductById(@Argument Integer id) {
        return this.productService.getById(id);
    }

    @MutationMapping
    public Product updateById(@Argument Integer id, @Argument String type) {
        return this.productService.updateProductById(id, type);
    }
}
