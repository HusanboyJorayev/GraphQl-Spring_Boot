package org.example.graphql.service;

import org.example.graphql.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductService {
    List<Product> getAllProduct();

    Product getById(Integer id);

    Product updateProductById(Integer id,String type);
}
